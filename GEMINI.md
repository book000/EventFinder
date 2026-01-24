# GEMINI.md

## 目的
- Gemini CLI 向けのコンテキストと作業方針を定義する。

## 出力スタイル
- 言語: 日本語
- トーン: 簡潔で事実ベース
- 形式: Markdown

## 共通ルール
- 会話は日本語で行う。
- PR とコミットは Conventional Commits に従う。
- PR タイトルとコミット本文の言語: PR タイトルは Conventional Commits 形式（英語推奨）。PR 本文は日本語。コミットは Conventional Commits 形式（description は日本語）。
- 日本語と英数字の間には半角スペースを入れる。

## プロジェクト概要
PaperMC 1.16.5以降用プラグイン。Minecraftサーバで発生したイベント情報をチャットに表示する。

### 技術スタック
- **言語**: Java
- **フレームワーク**: PaperMC (Bukkit API)
- **パッケージマネージャー**: Maven
- **主要な依存関係**:
  - Paper API v1.16.5-R0.1-SNAPSHOT
  - Kyori Adventure API v4.26.1
  - JetBrains Annotations v26.0.2-1
  - Reflections v0.10.2
  - JUnit v4.13.2

## コーディング規約
- フォーマット: 既存設定（ESLint / Prettier / formatter）に従う。
- 命名規則: 既存のコード規約に従う。
- コメント言語: 日本語
- エラーメッセージ: 英語

### 開発コマンド
```bash
# install
mvn install

# dev
mvn compile

# build
mvn clean package

# test
mvn test

```

## 注意事項
- 認証情報やトークンはコミットしない。
- ログに機密情報を出力しない。
- 既存のプロジェクトルールがある場合はそれを優先する。

## リポジトリ固有
- Minecraftプラグイン開発
- イベント情報の動的表示機能
- フィルタリング機能付き
- 設定のセーブ/ロード対応