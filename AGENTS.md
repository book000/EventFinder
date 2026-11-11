# AGENTS.md

Guidance for AI coding agents and contributors. `CLAUDE.md` imports this file, and `.github/copilot-instructions.md` adds the review checklist.

## Language

- All deliverables are written in **English**: commit messages, PR/Issue titles and bodies, review comments, code comments and JavaDoc, and documentation (`README.md`, `AGENTS.md`, etc.).
- Exceptions (keep as is): localized UI strings (the player-facing messages in `src/main/resources/i18n/*.yml`, with `ja-JP.yml` in Japanese), the intentionally kept Japanese translation `README-ja.md`, quotations, technical identifiers, generated files, and external source text.
- Runtime messages (logs, errors) are English.
- Keep `README-ja.md` in sync with `README.md` when the README changes.
- Do not rewrite Git history to change the language of past commits.

## Overview

EventFinder is a PaperMC plugin (Java 8 bytecode, Maven) that shows the events occurring on the server in the chat. A single jar supports every Paper version from 1.16.5 to the latest; no per-version build exists.

## Commands

```bash
mvn -B package        # compile, run the JUnit tests, and build the shaded jar
mvn test              # tests only
mvn -B package -DskipTests
```

- The build uses a recent JDK (CI uses Temurin 25) with `<release>8</release>`, so the bytecode and API level stay at Java 8. Do not use newer Java APIs.
- `target/EventFinder-<version>.jar` is the shaded plugin jar (`${version}` defaults to `0.0.0`; CI passes `-Dversion=...` on release). No runtime library is bundled: Paper API and Adventure are `provided` by the server.
- `tools/smoke-test.sh <Paper version> <jar>` downloads and starts a real Paper and checks that the plugin loads and displays events. `.github/workflows/paper-compat.yml` runs it for every Paper version since 1.16.5 that has a STABLE build (the list comes from `tools/paper-versions.py`) on pull requests, weekly, and on demand.
- There is no linter or formatter configuration.

## Structure

- `src/main/java/com/tomacheese/eventfinder/`
  - `Main.java`: plugin entry point. Registers the events, formats and shows them (`showEvent`, `converter`), holds the hide patterns and the filter, and provides `Main.plainText`.
  - `Commands.java`: the `/event` subcommands.
  - `Lib.java`: sends i18n messages (`[EventFinder]` prefix, player locale, falls back to the English default).
  - `I18nMsgType.java`: message keys with English default messages.
- `src/main/resources/`: `plugin.yml` (`api-version: 1.16`; do not change), `config.yml` (default `hidePattern` list and the package `color` map), `i18n/ja-JP.yml` and `i18n/en-US.yml`.
- `src/test/java/MainTest.java`: JUnit 4 tests for the i18n files and `Main.plainText`.
- `.github/workflows/`: `maven-ci.yml` (build and test), `paper-compat.yml` (smoke test), `release.yml` (on merge to `master`: tag, release, upload the jar).
- `.run/`: IntelliJ run configurations and a Windows helper script for local testing.

## How events work

- Events are discovered at startup by scanning the jar that provides `org.bukkit.event.Event`, limited to `org/bukkit/event/`, `io/papermc/paper/`, `com/destroystokyo/paper/` and `org/spigotmc/event/`. Every non-abstract `Event` subclass gets a listener; an event is shown only when `event.getClass()` equals the registered class, so parent and child events are never shown twice. Do not widen the scan, and do not add per-event listeners.
- Hide patterns are lowercased and match by prefix against the lowercased event name. They are stored under `hidePattern` in `config.yml`.
- Messages use Adventure `Component` and `NamedTextColor` (provided by Paper), not `ChatColor`.

## Conventions

- UTF-8, 4-space indentation.
- Player-facing text goes through `I18nMsgType` and must exist in both `en-US.yml` and `ja-JP.yml` (`MainTest#isAllDefinedI18nFileContents` checks this).
- Public classes and methods get English JavaDoc; comments explain why, not what.
- Update `README.md` and `README-ja.md` when commands or behavior change, and `plugin.yml` when commands or permissions change.
- Commits follow [Conventional Commits](https://www.conventionalcommits.org/); branches follow [Conventional Branch](https://conventional-branch.github.io) short form (`feat/...`, `fix/...`). The release version is derived from the commit types, so choose them deliberately.
- Do not commit to Renovate PRs. Never commit secrets.
