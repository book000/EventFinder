# EventFinder

[English README is here](README.md)

EventFinder は、サーバーで発生したイベントをチャット欄に表示する PaperMC 1.16.5 以降のプラグインです。1 つの jar で Paper 1.16.5 から最新バージョンまで対応し、イベントは実行中のサーバーから検出します。

石橋を叩いて壊すブログ様の [発生したイベントを画面に表示するプラグインを作った](https://www.jias.jp/blog/?84) のコードを修正・改良しています。

## Installation

[Releases](https://github.com/book000/EventFinder/releases) から jar ファイルをダウンロードし、サーバーの `plugins` ディレクトリに入れてください。

## Commands

`/event` コマンドには `eventfinder.command.event` 権限が必要です。この権限はデフォルトでオペレーターに付与されます。

- `/event <add|hide> <EventNamePattern>...`: 各 `EventNamePattern` を非表示条件に追加します。
- `/event <del|remove|show> <EventNamePattern>...`: 各 `EventNamePattern` を非表示条件から削除します。
- `/event toggle <EventNamePattern>`: パターンを非表示条件に追加します。すでに追加されている場合は削除します。チャット欄のイベント名をクリックすると、そのイベントに対してこのコマンドが実行されます。
- `/event filter <FilterString>`: `FilterString` を含むイベントのみを表示します。引数なしの `/event filter` でフィルターを解除します。
- `/event list`: 非表示条件の一覧を表示します。
- `/event save`: 非表示条件を `plugins/EventFinder/config.yml` に保存します。
- `/event load`: 非表示条件を `plugins/EventFinder/config.yml` から読み込みます。

非表示条件は、イベント名が (大文字小文字を区別せず) パターンで始まるすべてのイベントに一致します。`/event add`、`/event remove`、`/event toggle` による変更はすぐに保存されます。`/event load` は、サーバーの稼働中に加えられた編集を含む現在のファイルをディスクから読み込みます。

## Specifications

- フラットワールドでの使用を強くお勧めします。
- 大量に発生する一部のイベントは、はじめから非表示になっています (`config.yml` の `hidePattern` を参照)。非表示のイベントは、すべての詳細を表示するデバッグモードでも、リフレクションによる詳細の取得やメッセージの描画の前に処理をスキップします。
- 各イベントは非表示条件とフィルターのスナップショットを使用するため、コマンドで設定を変更している間も非同期イベントを安全に整形できます。非表示条件の読み込みでは、リスト全体を一度に置き換えます。
- イベントは `eventfinder.view` 権限を持つオンラインプレイヤー (デフォルトではオペレーター) にのみ表示されます。コンソールにはデバッグモードでもイベントのクラス名のみが出力されます。デフォルトではイベント名とメタデータのみが表示され、リフレクションによるフィールド値は表示されません。イベント名にカーソルを合わせると、クラスとメソッドの一覧を確認できます。
- 詳細出力では、static ではない引数なしの getter のみを呼び出します。`get` または `is` を除いた名前が重複する場合は、安定した順序で 1 つを選び、`get` を `is` より優先します。
- リフレクションによるすべての詳細を表示するには、`plugins/EventFinder/config.yml` で `debug.fullEventDetails: true` を設定してサーバーを再起動してください。ログインアドレスや非公開コマンドなど任意のイベントデータが `eventfinder.view` 権限を持つ全員に公開されます。この権限は信頼できるユーザーにのみ付与し、信頼できるデバッグ環境でのみ有効にしてください。設定がない既存の config でも安全なデフォルトが適用されます。
- キャンセルされたイベントは取消線で表示されます。イベントクラスが非推奨のフィールドを宣言している場合は、イベント名の後ろに `*` が付きます。
- イベントのクラス名はパッケージごとに色分けされます (`config.yml` の `color` を参照)。
- メッセージはプレイヤーのロケールに応じて、英語と日本語で表示されます。

## Thanks

- このプラグインの元となる `EventCatchAll.jar` を制作・公開していただいている [石橋を叩いて壊すブログ](https://www.jias.jp/blog/) 様に感謝申し上げます。
