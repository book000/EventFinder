import re
import textwrap
import sys
import requests
from bs4 import BeautifulSoup

def get_sub_classes_from_tree(version: str, base_class_path: str):
    """overview-tree.html からサブクラス一覧を取得するフォールバック関数。
    クラスページが空（0 バイト）のときに使用する。"""
    print("get_sub_classes_from_tree: using overview-tree.html fallback")
    url = "https://jd.papermc.io/paper/%s/overview-tree.html" % version
    html = requests.get(url)
    soup = BeautifulSoup(html.text, "html.parser")

    # base_class_path に対応する <a> タグを探す（例: "org/bukkit/event/Event.html"）
    event_a = None
    for a in soup.find_all("a", href=True):
        if a.get("href") == base_class_path:
            event_a = a
            break

    if event_a is None:
        return []

    # <li> まで遡る
    li = event_a
    while li and li.name != "li":
        li = li.parent

    if li is None:
        return []

    # この <li> の配下にある全クラスリンクを収集する
    def collect_classes(node):
        result = []
        for a in node.find_all("a", class_="type-name-link"):
            title = a.get("title", "")
            parts = title.split(" ")
            # title 例: "class in org.bukkit.event.block"
            if len(parts) >= 3 and parts[0] == "class":
                package = parts[-1]
                simple_name = a.text.strip()
                result.append(package + "." + simple_name)
        return result

    return collect_classes(li)


def get_sub_classes(version: str,
                    className: str):
    print("get_sub_classes: %s" % className)
    sub_classes = []
    url = "https://jd.papermc.io/paper/%s/%s.html" % (version, className.replace(".", "/"))

    html = requests.get(url)

    # クラスページが空の場合は overview-tree.html からフォールバック取得
    if not html.text.strip() and className == "org.bukkit.event.Event":
        return get_sub_classes_from_tree(version, className.replace(".", "/") + ".html")

    soup = BeautifulSoup(html.text, "html.parser")
    notes = soup.find_all("dl", {"class": "notes"})
    sub_classes_tags = []
    is_found_sub_classes = False
    for note in notes:
        if note.find("dt").text != "Direct Known Subclasses:":
            continue
        sub_classes_tags = note.find("dd").find_all("a")
        is_found_sub_classes = True
        break

    if not is_found_sub_classes:
        return [className]

    for sub_class_tag in sub_classes_tags:
        title = sub_class_tag.get("title")
        package = title.split(" ")[len(title.split(" ")) - 1]
        simple_class_name = sub_class_tag.text
        sub_class_name = package + "." + simple_class_name

        sub_classes.extend(get_sub_classes(version, sub_class_name))

    return sub_classes


def main():
    version = sys.argv[1]

    if version == "null":
        raise Exception("Version is null")

    sub_classes = get_sub_classes(version, "org.bukkit.event.Event")
    print("sub_classes count: %s" % len(sub_classes))
    print(sub_classes)

    for sub_class in sub_classes:
        simple_class_name = sub_class.split(".")[len(sub_class.split(".")) - 1]
        text = textwrap.dedent(f"""
            package com.tomacheese.eventfinder.listeners;

            import com.tomacheese.eventfinder.Main;
            import org.bukkit.event.EventHandler;
            import org.bukkit.event.Listener;
            import {sub_class};

            public class On{simple_class_name} implements Listener %START%
                public On{simple_class_name}()%START%%END%
                @EventHandler
                public void on{simple_class_name}({simple_class_name} event)%START%
                    Main.showEvent(event);
                %END%
            %END%
        """.replace(r"%START%", "{").replace(r"%END%", "}")).strip()

        with open("./src/main/java/com/tomacheese/eventfinder/listeners/On" + simple_class_name + ".java", "w") as f:
            f.write(text)
            print("Written: On" + simple_class_name + ".java")


main()
