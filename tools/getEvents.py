import pathlib
import re
import textwrap
import sys
import requests
from bs4 import BeautifulSoup


def get_from_noframe(version: str):
    url = "https://papermc.io/javadocs/paper/" + version + "/allclasses-noframe.html"

    html = requests.get(url)
    if html.status_code != 200:
        return None
    soup = BeautifulSoup(html.text, "html.parser")

    indexContainer = soup.find("div", {"class": "indexContainer"})
    if indexContainer is None:
        print("Not found indexContainer.")
        return None

    return indexContainer.find("ul").find_all("li")


def get_from_index(version: str):
    url = "https://papermc.io/javadocs/paper/" + version + "/allclasses-index.html"

    html = requests.get(url)
    if html.status_code != 200:
        return None
    soup = BeautifulSoup(html.text, "html.parser")

    table = soup.find("div", {"id": "all-classes-table.tabpanel"})
    if table is None:
        print("Not found all-classes-table.tabpanel.")
        return None

    return table.select("div.col-first.all-classes-table")


def get_sub_classes(version: str,
                    className: str):
    print("get_sub_classes: %s" % className)
    sub_classes = []
    url = "https://papermc.io/javadocs/paper/%s/%s.html" % (version, className.replace(".", "/"))

    html = requests.get(url)
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

    pattern = re.compile(r"^[1-9]+\.[0-9]+")
    if pattern.fullmatch(version) is None:
        version = pattern.match(version).group()

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
