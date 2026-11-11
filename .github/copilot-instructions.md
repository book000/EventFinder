# Copilot review instructions

Follow `AGENTS.md` for project guidance, conventions, and the language policy. Review comments are written in English.

## Review checklist

- Java 8 compatibility: no APIs newer than Java 8 (`<release>8</release>`).
- Player-facing text goes through `I18nMsgType` and exists in both `src/main/resources/i18n/en-US.yml` and `ja-JP.yml`.
- Chat output uses Adventure `Component` / `NamedTextColor`, not `ChatColor`. Adventure and Paper API are not bundled in the jar.
- Event registration stays automatic (jar scan in `Main#registerEvents`), shows an event only when its runtime class matches, and does not widen the scanned packages.
- Command or permission changes update `plugin.yml`; command or behavior changes update `README.md` and `README-ja.md`.
- No secrets, and no player personal data in logs.

## Known patterns that are not problems

- No per-event listener classes: events are discovered by scanning the API jar.
- `${version}` in `pom.xml` is substituted at build time.
- `org.bukkit.event.*` strings in `config.yml` are package names for coloring, not unused code.

## Language

- Deliverables are written in English: code comments, JavaDoc, documentation, commit messages, PR text, and review comments.
- Exceptions: localized UI strings (`i18n/*.yml`), the Japanese `README-ja.md`, quotations, and technical identifiers.
