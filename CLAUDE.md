# Claude Code 作業方針

## 目的

このファイルは、EventFinder プロジェクトにおける Claude Code の作業方針とプロジェクト固有ルールを定義します。

## 判断記録のルール

判断は必ずレビュー可能な形で記録すること：

1. 判断内容の要約
2. 検討した代替案
3. 採用しなかった案とその理由
4. 前提条件・仮定・不確実性
5. 他エージェントによるレビュー可否

前提・仮定・不確実性を明示すること。仮定を事実のように扱ってはならない。

## プロジェクト概要

- **目的**: Minecraft サーバー (PaperMC) で発生したイベントをチャット欄に表示するプラグイン
- **主な機能**:
  - イベントの自動検出と表示
  - イベントの非表示フィルター管理
  - フィルター条件の永続化 (load/save)
  - 国際化対応 (日本語・英語)
  - パッケージごとの色分け表示

## 技術スタック

- **言語**: Java 8 (`java.version` = 8。`maven-compiler-plugin` の `<release>8</release>` でソース・バイトコードレベルを 8 に固定)
- **ビルドツール**: Maven (ビルドには新しい JDK を使用するが、バイトコードは Java 8。使用する JDK は `.github/workflows/*.yml` を正とする)
- **フレームワーク**: PaperMC 1.16.5 API (`com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT`、`provided` スコープ)
- **対応バージョン**: 1 つの jar で Paper 1.16.5 から最新の Paper までのすべてのバージョンに対応する (バージョンごとのビルドは行わない)
- **主要ライブラリ**:
  - 実行時ライブラリは一切同梱しない (shaded jar にはプラグイン自身のクラスのみが含まれる)。Adventure API は実行時に Paper が提供するものを使用する
  - JUnit 4.13.2 (テスト)

## 重要ルール

- **会話言語**: 日本語
- **コミット規約**: [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) に従う。`<description>` は日本語で記載
- **コード内コメント**: 日本語
- **エラーメッセージ**: 英語
- **日本語と英数字の間**: 半角スペースを挿入

## 環境のルール

- **ブランチ命名**: [Conventional Branch](https://conventional-branch.github.io) に従う。`<type>` は短縮形 (feat, fix) を使用
  - 例: `feat/add-event-filter`, `fix/null-pointer-exception`
- **GitHub リポジトリ調査**: テンポラリディレクトリに `git clone` してコード検索
- **Renovate PR の扱い**: Renovate が作成した既存のプルリクエストに対して、追加コミットや更新を行わない

## コード改修時のルール

- 文字コードは UTF-8、インデントはスペース 4 つ
- 日本語と英数字の間には、半角スペースを挿入する
- 既存のエラーメッセージで先頭に絵文字がある場合は、全体でエラーメッセージに絵文字を設定する。絵文字はエラーメッセージに即した一文字の絵文字である必要がある
- 関数やインターフェースには、docstring (JavaDoc) を記載・更新する。日本語で記載する

## 相談ルール

Codex CLI や Gemini CLI の他エージェントに相談することができます。以下の観点で使い分けてください。

### Codex CLI (ask-codex)

- 実装コードに対するソースコードレビュー
- 関数設計、モジュール内部の実装方針などの局所的な技術判断
- アーキテクチャ、モジュール間契約、パフォーマンス／セキュリティといった全体影響の判断
- 実装の正当性確認、機械的ミスの検出、既存コードとの整合性確認

### Gemini CLI (ask-gemini)

- SaaS 仕様、言語・ランタイムのバージョン差、料金・制限・クォータといった、最新の適切な情報が必要な外部依存の判断
- 外部一次情報の確認、最新仕様の調査、外部前提条件の検証

### 指摘への対応ルール

他エージェントが指摘・異議を提示した場合、Claude Code は必ず以下のいずれかを行う。黙殺・無言での不採用は禁止する。

- 指摘を受け入れ、判断を修正する
- 指摘を退け、その理由を明示する

以下は必ず実施してください。

- 他エージェントの提案を鵜呑みにせず、その根拠や理由を理解する
- 自身の分析結果と他エージェントの意見が異なる場合は、双方の視点を比較検討する
- 最終的な判断は、両者の意見を総合的に評価した上で、自身で下す

## 開発コマンド

```bash
# 依存関係の解決
mvn dependency:resolve

# ビルド (テスト含む)
mvn package

# クリーン
mvn clean

# テスト実行
mvn test

# ビルド (テストなし)
mvn package -DskipTests
```

## アーキテクチャと主要ファイル

### ディレクトリ構造

```
src/
├── main/
│   ├── java/com/tomacheese/eventfinder/
│   │   ├── Main.java                  # プラグインメインクラス
│   │   ├── Commands.java              # コマンドハンドラー
│   │   ├── Lib.java                   # ユーティリティクラス
│   │   └── I18nMsgType.java           # 国際化メッセージタイプ
│   └── resources/
│       ├── plugin.yml                 # プラグイン定義
│       ├── config.yml                 # デフォルト設定
│       └── i18n/                      # 国際化リソース
│           ├── ja-JP.yml
│           └── en-US.yml
└── test/
    └── java/
        └── MainTest.java              # テストクラス
```

### 主要クラスと責務

- `Main.java`: プラグインのエントリーポイント、イベント登録 (`Main#registerEvents`)、フィルター管理、`Main.plainText` (Adventure の `PlainComponentSerializer` の代替となる public static ヘルパー)
- `Commands.java`: `/event` コマンドの処理
- `Lib.java`: 共通ユーティリティメソッド
- `I18nMsgType.java`: 国際化メッセージのタイプ定義

## 実装パターン

### 推奨パターン

- イベントは起動時の jar スキャンで自動検出される (詳細は「リポジトリ固有」を参照)
- チャットメッセージは Paper が実行時に提供する Adventure API の `Component` を使用して構築する
- 国際化メッセージは `I18nMsgType` 経由でアクセスする
- 設定は `config.yml` で管理し、`FileConfiguration` で読み込む

### 非推奨パターン

- 直接 `ChatColor` を使用しない (Adventure API の `NamedTextColor` を使用)
- ハードコードされたメッセージ (国際化対応すること)
- イベントの手動登録・イベントごとのリスナークラスの追加 (自動検出に任せる)
- Adventure API の同梱 (Paper が提供するものを使用する)

## テスト

- **テストフレームワーク**: JUnit 4 (モックライブラリは導入していない)
- **既存テスト**: `src/test/java/MainTest.java` は i18n リソースと `Main.plainText` を対象とする
  - `plainTextConcatenatesNestedTextContent`: `Main.plainText` が入れ子の `Component` のテキストを連結することを検証する
  - `isAllDefinedI18nFileContents`: 各言語ファイルに `I18nMsgType` の全定義が揃っているか検証する
  - `isCorrectI18nFile`: `i18n/*.yml` のファイル名を `Locale.getAvailableLocales()` と突き合わせる。ただし `Locale#toString()` はアンダースコア区切り (`ja_JP`) を返す一方、ファイル名はハイフン区切り (`ja-JP`) のため、現状のファイル群では実質的な検証になっていない点に注意
- **テスト方針**: 新規機能追加時は、可能な範囲で対応するテストケースを追加する
- **テストコマンド**: `mvn test`

## ドキュメント更新ルール

### 更新対象

- `README.md` / `README-ja.md`: 機能追加、コマンド変更時
- `src/main/resources/plugin.yml`: コマンドやパーミッション変更時 (`api-version: 1.16` を指定している。変更しないこと)
- `src/main/resources/i18n/*.yml`: メッセージ追加・変更時
- JavaDoc: クラス・メソッド追加・変更時

### 更新タイミング

- コード変更と同時にドキュメントを更新する
- PR 作成前に必ずドキュメントの整合性を確認する

## 作業チェックリスト

### 新規改修時

1. プロジェクトを理解する
2. 作業ブランチが適切であることを確認する
3. 最新のリモートブランチに基づいた新規ブランチであることを確認する
4. PR がクローズされた不要ブランチが削除済みであることを確認する
5. 指定されたパッケージマネージャー (Maven) で依存関係をインストールする

### コミット・プッシュ前

1. Conventional Commits に従っていることを確認する
2. センシティブな情報が含まれていないことを確認する
3. Lint / Format エラーがないことを確認する (Maven でビルドが通ることを確認)
4. 動作確認を行う

### PR 作成前

1. PR 作成の依頼があることを確認する
2. センシティブな情報が含まれていないことを確認する
3. コンフリクトの恐れがないことを確認する

### PR 作成後

1. コンフリクトがないことを確認する
2. PR 本文が最新状態のみを網羅していることを確認する
3. `gh pr checks <PR ID> --watch` で CI を確認する
4. Copilot レビューに対応し、コメントに返信する
5. Codex のコードレビューを実施し、スコア 50 以上の指摘対応を行う
6. PR 本文の崩れがないことを確認する

## リポジトリ固有

- このプラグインは PaperMC 1.16.5 から最新の Paper まで、1 つの jar で動作する
- イベントは起動時に、`org.bukkit.event.Event` を提供する jar のうち `org/bukkit/event/`、`io/papermc/paper/`、`com/destroystokyo/paper/`、`org/spigotmc/event/` 配下のクラスをスキャンして自動検出する。抽象クラスでない `Event` のサブクラスはすべて登録され、`event.getClass() == clazz` の場合のみ表示するため、親子関係にあるイベントが二重に表示されることはなく、末端でない具象イベントも表示される
- チャットメッセージは Paper が実行時に提供する Adventure API を使用して表示される
- 国際化 (i18n) は `src/main/resources/i18n/` 配下の YAML ファイルで管理される
- ビルド成果物は `target/` ディレクトリに生成される
- GitHub Actions CI は新しい JDK で `mvn -B package` によりビルド・テストを実行する。`release.yml` は単一の jar をビルドする
- フラットワールドでの使用を推奨 (イベント量が管理しやすいため)
- 一部のイベント (大量に発生するもの) はデフォルトで非表示になっている
- パッケージごとに色分けされたチャットメッセージが表示される
- 非推奨イベントはアスタリスク (`*`) 付きで表示され、キャンセル済みイベントは取り消し線で表示される
- jar スキャンは起動時に API jar のイベントパッケージ配下のクラスを読み込むため、スキャン対象を広げないようにしてパフォーマンスに注意する
- Paper を実際に起動するスモークテストを実行し、新しい Paper リリースによる破損を検知する。毎週 (および手動実行) は 1.16.5 以降の全安定版、PR では最古 (1.16.5) と最新の安定版のみを対象とする。対象バージョンや実行タイミングは `.github/workflows/paper-compat.yml` と `tools/paper-versions.py` を正とする
