# EventFinder

[Click here for English README](README.md)

発生したイベントをチャット欄に表示する PaperMC 1.16.5 以降のプラグインです。  
石橋を叩いて壊すブログ様の [発生したイベントを画面に表示するプラグインを作った](https://www.jias.jp/blog/?84) のコードを修正・改良しています。

## Installation

[Releases](https://github.com/book000/EventFinder/releases) から jar ファイルをダウンロードし、 `plugins` ディレクトリに入れてください。

## Commands

- `/event <add|hide> <EventNamePattern>`: `EventNamePattern` を非表示条件に追加します。
- `/event <del|remove|show> <EventNamePattern>`: `EventNamePattern` を非表示条件から削除します。
- `/event filter <FilterString>`: `FilterString` を含むイベント情報のみを表示します。
- `/event list`: 非表示条件の一覧を表示します。
- `/event save`: 非表示条件をファイルへセーブします。
- `/event load`: 非表示条件をファイルからロードします。

## Specifications

- フラットワールドでの使用を強くお勧めいたします。
- いくつかのイベントは大量に表示されてしまうため、はじめから無効化しています。
- 非推奨イベントは取消線で表示されます。
- クラスのメソッドは `get` または `is` で始まるメソッドの返り値を表示しています。但し、 `Handler` を含む場合を除きます。

## Thanks

- このプラグインの元となる `EventCatchAll.jar` を制作・公開して頂いている [石橋を叩いて壊すブログ](https://www.jias.jp/blog/) 様に感謝申し上げます。
