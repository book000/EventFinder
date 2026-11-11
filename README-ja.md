# EventFinder

[English README is here](README.md)

EventFinder は、サーバーで発生したイベントをチャット欄に表示する PaperMC 1.16.5 以降のプラグインです。1 つの jar で Paper 1.16.5 から最新バージョンまで対応し、イベントは実行中のサーバーから検出します。

石橋を叩いて壊すブログ様の [発生したイベントを画面に表示するプラグインを作った](https://www.jias.jp/blog/?84) のコードを修正・改良しています。

## Installation

[Releases](https://github.com/book000/EventFinder/releases) から jar ファイルをダウンロードし、サーバーの `plugins` ディレクトリに入れてください。

## Commands

`/event` コマンドは、デフォルトではオペレーターが使用できます。

- `/event <add|hide> <EventNamePattern>...`: 各 `EventNamePattern` を非表示条件に追加します。
- `/event <del|remove|show> <EventNamePattern>...`: 各 `EventNamePattern` を非表示条件から削除します。
- `/event toggle <EventNamePattern>`: パターンを非表示条件に追加します。すでに追加されている場合は削除します。チャット欄のイベント名をクリックすると、そのイベントに対してこのコマンドが実行されます。
- `/event filter <FilterString>`: `FilterString` を含むイベントのみを表示します。引数なしの `/event filter` でフィルターを解除します。
- `/event list`: 非表示条件の一覧を表示します。
- `/event save`: 非表示条件を `plugins/EventFinder/config.yml` に保存します。
- `/event load`: 非表示条件を `plugins/EventFinder/config.yml` から読み込みます。

非表示条件は、イベント名が (大文字小文字を区別せず) パターンで始まるすべてのイベントに一致します。パターンを 1 つだけ指定した `/event add` と `/event remove` は、メモリ上の条件だけを変更します。再起動後も保持するには `/event save` を実行してください。複数のパターンを指定した場合と `/event toggle` では、条件がすぐに保存されます。

## Specifications

- フラットワールドでの使用を強くお勧めします。
- 大量に発生する一部のイベントは、はじめから非表示になっています (`config.yml` の `hidePattern` を参照)。
- 各イベントは、クラス名と、`get*` および `is*` メソッドの返り値で表示されます (名前に `Handler` を含むメソッドは除きます)。イベント名にカーソルを合わせると、クラスとメソッドの一覧を確認できます。
- キャンセルされたイベントは取消線で表示されます。イベントクラスが非推奨のフィールドを宣言している場合は、イベント名の後ろに `*` が付きます。
- イベントのクラス名はパッケージごとに色分けされます (`config.yml` の `color` を参照)。
- メッセージはプレイヤーのロケールに応じて、英語と日本語で表示されます。

## Thanks

- このプラグインの元となる `EventCatchAll.jar` を制作・公開していただいている [石橋を叩いて壊すブログ](https://www.jias.jp/blog/) 様に感謝申し上げます。
