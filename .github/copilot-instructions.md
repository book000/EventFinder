# GitHub Copilot Instructions

## プロジェクト概要

- 目的: Minecraft サーバー (PaperMC) で発生したイベントをチャット欄に表示するプラグイン
- 主な機能: イベントの自動検出、チャット表示、非表示フィルター管理、国際化対応
- 対象ユーザー: Minecraft サーバー管理者、開発者

## 共通ルール

- 会話は日本語で行う。
- PR とコミットは Conventional Commits に従う。`<description>` は日本語で記載する。
  - 例: `feat: イベントフィルター機能を追加`
- 日本語と英数字の間には半角スペースを入れる。

## 技術スタック

- 言語: Java 8
- フレームワーク: PaperMC 1.16.5 API
- ビルドツール: Maven
- 主要ライブラリ:
  - Adventure API 4.26.1 (チャットメッセージ表示)
  - Reflections 0.10.2 (イベント自動検出)
  - JUnit 4.13.2 (テスト)

## コーディング規約

- 文字コード: UTF-8
- Java バージョン: 1.8
- コメント: 日本語で記載する
- エラーメッセージ: 英語で記載する
- 命名規則: Java 標準の命名規則に従う (camelCase, PascalCase)
- インデント: スペース 4 つ
- docstring: すべての public メソッドとクラスに JavaDoc を日本語で記載する

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

## テスト方針

- テストフレームワーク: JUnit 4
- テストディレクトリ: `src/test/java/`
- 新規機能追加時は、対応するテストケースを追加する
- テストコマンド: `mvn test`

## セキュリティ / 機密情報

- API キーや認証情報を Git にコミットしない
- ログに機密情報を出力しない
- プレイヤーの個人情報を適切に扱う

## ドキュメント更新

コードを変更する際は、以下のドキュメントも更新する：

- `README.md` / `README-ja.md`: 機能追加、コマンド変更時
- `src/main/resources/plugin.yml`: コマンドやパーミッション変更時
- `src/main/resources/i18n/*.yml`: メッセージ追加・変更時
- JavaDoc: クラス・メソッド追加・変更時

## リポジトリ固有

- このプラグインは PaperMC 1.16.5 以降で動作する
- イベントは Reflections ライブラリを使用して自動検出される
- チャットメッセージは Adventure API を使用して表示される
- 国際化 (i18n) は `src/main/resources/i18n/` 配下の YAML ファイルで管理される
- ビルド成果物は `target/` ディレクトリに生成される
- GitHub Actions CI では `mvn -B package` でビルド・テストが実行される
