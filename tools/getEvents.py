import textwrap

import requests
from bs4 import BeautifulSoup


def main():
    url = "https://papermc.io/javadocs/paper/1.16/allclasses-noframe.html"

    html = requests.get(url)
    soup = BeautifulSoup(html.text, "html.parser")

    indexContainer = soup.find("div", {"class": "indexContainer"})
    if indexContainer is None:
        print("Not found indexContainer.")
        exit(1)

    lis = indexContainer.find("ul").find_all("li")

    imports = []
    for li in lis:
        # <li><a href="org/bukkit/entity/AbstractArrow.html" title="interface in org.bukkit.entity"><span class="interfaceName">AbstractArrow</span></a></li>

        href = li.find("a").get("href")
        import_text = "import " + \
            href.replace("/", ".").replace(".html", "") + ";"
        name = li.find("a").text

        if not name.endswith("Event"):
            continue

        imports.append("add(new On{name}());".format(name=name))
        text = textwrap.dedent(f"""
            package com.tomacheese.eventfinder.listeners;

            import com.tomacheese.eventfinder.Main;
            import org.bukkit.event.EventHandler;
            import org.bukkit.event.Listener;
            {import_text}

            public class On{name} implements Listener %START%
                public On{name}()%START%%END%
                @EventHandler
                public void on{name}({name} event)%START%
                    Main.showEvent(event);
                %END%
            %END%
        """.replace(r"%START%", "{").replace(r"%END%", "}")).strip()

        with open("files/On" + name + ".java", "w") as f:
            f.write(text)
            print("Written: files/On" + name + ".java")

    print()
    print("\n".join(imports))



main()
