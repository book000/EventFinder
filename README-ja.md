# EventFinder

[Click here for English README](README.md)

発生したイベントをチャット欄に表示する PaperMC 1.16.5 のプラグインです。  
石橋を叩いて壊すブログ様の [発生したイベントを画面に表示するプラグインを作った](https://www.jias.jp/blog/?84) のコードを修正・改良しています。

## Installation

[Releases](https://github.com/book000/FirstPlayerNotify/releases) から jar ファイルをダウンロードし、 `plugins` ディレクトリに入れてください。

## Commands

- `/event <add|hide> <EventNamePattern>`: `EventNamePattern` を非表示条件に追加します。
- `/event <del|remove|show> <EventNamePattern>`: `EventNamePattern` を非表示条件から削除します。
- `/event list`: 非表示条件の一覧を表示します。
- `/event save`: 非表示条件をファイルへセーブします。
- `/event load`: 非表示条件をファイルからロードします。

## Specifications

- フラットワールドでの使用を強くお勧めいたします。
- いくつかのイベントは大量に表示されてしまうため、はじめから無効化しています。
- 非推奨イベントは取消線で表示されます。
- クラスのメソッドは `get` または `is` で始まるメソッドの返り値を表示しています。但し、 `Handler` を含む場合を除きます。

## Development

今後、Minecraftのアップデートに伴いイベントが増えた場合、以下の方法でプラグインをアップデートできます。フォークしてお使いください。

1. 対象のパッケージのJavaDocを用意します。
2. 上部ヘッダーの `All Classes` をクリックします。
3. `allclasses-noframe.html` のページに移動するので、このページの URL をコピーします。
4. [`tools/getEvents.py`](tools/getEvents.py) を開き、 `url = "https://papermc.io/javadocs/paper/1.16/allclasses-noframe.html"` を置き換えます。
5. 実行すると、 `tools/files` に Java ファイルが生成され、またターミナルに `add(new On...)` というように一覧が表示されるので、これらをコピーします。
6. `tools/files` の中身を `src/main/java/com/tomacheese/eventfinder/listeners` に移動します。
7. `add(new On...)` の一覧を、 `src/main/java/com/tomacheese/eventfinder/Main.java` の `registerEvents()` にある `Set<Listener> listeners` にペーストします。
8. あとは `pom.xml` をバージョンに合わせて編集し、ビルドするだけです！

## Thanks

- このプラグインの元となる `EventCatchAll.jar` を制作・公開して頂いている [石橋を叩いて壊すブログ](https://www.jias.jp/blog/) 様に感謝申し上げます。
