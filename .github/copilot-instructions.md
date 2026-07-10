# GitHub Copilot コードレビュー指示

EventFinder (PaperMC 1.16.5 向けイベント表示プラグイン、Java 8 / Maven) の
プルリクエストをレビューする際の観点。開発手順は `CLAUDE.md` を参照。

## レビュー言語

- レビューコメントは日本語で記載する。
- 日本語と英数字の間には半角スペースを入れる。

## 規約として確認する点

このリポジトリには Checkstyle 等の linter 設定は無く、規約は以下を目視で確認する。

- ソースエンコーディングは UTF-8、インデントはスペース 4 つ。
- コード内コメントは日本語。ユーザー/ログ向けエラーメッセージは英語。
- public なクラス・メソッドには日本語の JavaDoc があること。
- `java.version` は 1.8。Java 9 以降でしか使えない API を新規に導入していないこと。

## 重点的に確認する点

- **国際化**: プレイヤー向けの文言をハードコードしていないか。新規メッセージは
  `src/main/resources/i18n/ja-JP.yml` と `en-US.yml` の両方に追加され、
  `I18nMsgType` 経由で参照されているか。
- **チャット表示**: `org.bukkit.ChatColor` や旧来の文字列連結ではなく、
  Adventure API の `Component` / `NamedTextColor` を使用しているか。
- **イベントリスナー**: `com.tomacheese.eventfinder.listeners` パッケージに配置され、
  手動登録ではなく Reflections による自動検出に委ねているか。
- **設定の永続化**: フィルター条件など設定の load/save が `config.yml` /
  `FileConfiguration` の既存パターンに沿っているか。
- **エラーハンドリング**: 既存エラーメッセージが先頭に絵文字を持つ場合、
  追加するメッセージも内容に即した一文字の絵文字を付けているか。
- **plugin.yml との整合**: コマンドやパーミッションの追加・変更時に
  `src/main/resources/plugin.yml` が更新されているか。
- **ドキュメント整合**: 機能・コマンド変更時に `README.md` / `README-ja.md` が
  更新されているか。

## セキュリティ

- API キーや認証情報がコミットされていないか。
- ログにプレイヤーの個人情報や機密情報を出力していないか。

## フラグすべきでない既知パターン

- Reflections によるリスナーの自動検出（明示的な登録が無くても正しい）。
- `src/main/java/com/tomacheese/eventfinder/listeners/.gitkeep`（空ディレクトリ維持用）。
- `org.bukkit.event` パッケージ名の参照は `config.yml` の色分け設定用であり、
  自動検出対象ではない（未使用ではない）。
- `pom.xml` の `${version}` プレースホルダーはビルド時に差し込まれる（誤設定ではない）。
