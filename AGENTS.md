# AI エージェント作業方針

## 目的

このファイルは、EventFinder プロジェクトにおける AI エージェント共通の作業方針を定義します。

## 基本方針

- **会話言語**: 日本語
- **コメント言語**: 日本語
- **エラーメッセージ言語**: 英語
- **日本語と英数字の間**: 半角スペースを挿入
- **コミット規約**: [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) に従う。`<description>` は日本語で記載
  - 例: `feat: イベントフィルター機能を追加`

## 判断記録のルール

技術的判断を行う際は、以下を記録すること：

1. **判断内容の要約**: 何を決定したか
2. **代替案**: 検討した他の選択肢
3. **採用理由**: なぜこの案を選んだか
4. **前提条件**: 判断の前提となる事実
5. **不確実性**: 確定していない要素や将来的なリスク

仮定を事実のように扱わず、明確に区別すること。

## プロジェクト概要

- **プロジェクト名**: EventFinder
- **目的**: Minecraft サーバー (PaperMC) で発生したイベントをチャット欄に表示するプラグイン
- **技術スタック**:
  - 言語: Java 8
  - ビルドツール: Maven
  - フレームワーク: PaperMC 1.16.5 API
  - 主要ライブラリ: Adventure API, Reflections, JUnit

## 開発手順（概要）

### 1. プロジェクト理解

- README を読み、プロジェクトの目的と機能を理解する
- `pom.xml` で技術スタックを確認する
- `src/main/java` でコード構造を把握する

### 2. 依存関係インストール

```bash
mvn dependency:resolve
```

### 3. 変更実装

- 既存のコーディング規約に従う
- JavaDoc を日本語で記載する
- 国際化が必要な場合は `i18n/*.yml` を更新する

### 4. テストと Lint/Format 実行

```bash
# ビルドとテスト
mvn package

# テストのみ
mvn test
```

## セキュリティ / 機密情報

- API キーや認証情報を Git にコミットしない
- ログに機密情報や個人情報を出力しない
- プレイヤーのデータを適切に扱う

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

## リポジトリ固有

- このプラグインは PaperMC 1.16.5 以降の Minecraft サーバーで動作する
- イベントは Reflections ライブラリで自動検出される (`org.bukkit.event` パッケージ)
- チャットメッセージは Adventure API の `Component` で構築する
- 国際化リソースは `src/main/resources/i18n/` 配下の YAML ファイルで管理する
- ビルド成果物は `target/` ディレクトリに生成される
- GitHub Actions CI では Java 8 (adopt distribution) を使用してビルド・テストが実行される
- フラットワールドでの使用を推奨 (イベント量が管理しやすいため)
