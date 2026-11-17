# EventFinder

[日本語の README はこちら](README-ja.md)

EventFinder is a PaperMC plugin (1.16.5 or later) that displays the events occurring on the server in the chat. A single jar supports every Paper version from 1.16.5 to the latest, and the events are detected from the running server.

The code is modified and improved from the code in [発生したイベントを画面に表示するプラグインを作った](https://www.jias.jp/blog/?84) of the "石橋を叩いて壊すブログ".

## Installation

Download the jar file from [Releases](https://github.com/book000/EventFinder/releases) and move it into the server's `plugins` directory.

## Commands

The `/event` command requires the `eventfinder.command.event` permission, which is granted to operators by default.

- `/event <add|hide> <EventNamePattern>...`: Adds each `EventNamePattern` to the hide conditions.
- `/event <del|remove|show> <EventNamePattern>...`: Removes each `EventNamePattern` from the hide conditions.
- `/event toggle <EventNamePattern>`: Adds the pattern to the hide conditions, or removes it if it is already there. Clicking an event name in the chat runs this command for that event.
- `/event filter <FilterString>`: Displays only the events whose text includes `FilterString`. `/event filter` without an argument clears the filter.
- `/event list`: Displays the hide conditions.
- `/event save`: Saves the hide conditions to `plugins/EventFinder/config.yml`.
- `/event load`: Loads the hide conditions from `plugins/EventFinder/config.yml`.

A hide condition matches every event whose name starts with the pattern, case-insensitively. `/event add` and `/event remove` with a single pattern change the conditions in memory only, so run `/event save` to keep them across restarts. With several patterns, and with `/event toggle`, the conditions are saved immediately.

## Specifications

- It is highly recommended to use it in a flat world.
- Some events that occur in large numbers are hidden from the beginning (see `hidePattern` in `config.yml`). Hidden events are skipped before reflective detail access and message rendering, including in full-detail debug mode.
- Each event uses a snapshot of the hide patterns and filter, so asynchronous events can be formatted safely while commands change these settings. Loading hide patterns replaces the entire list at once.
- Event output is sent only to online players with the `eventfinder.view` permission (operators by default); the console receives only event class names, even in debug mode. By default, only event names and metadata are shown, and reflective field values are omitted. Hover over the event name to see the class and its methods.
- Detailed output invokes only non-static, zero-argument getters; when getters share a name after removing `get` or `is`, a stable order chooses one, with `get` before `is`.
- To enable full reflective dumps, set `debug.fullEventDetails: true` in `plugins/EventFinder/config.yml` and restart the server. This exposes arbitrary event data, including login addresses and private commands, to every player with `eventfinder.view`; grant that permission only to trusted users and enable this mode only in a trusted debugging environment. Existing configs without this setting remain in the safe default mode.
- Cancelled events are shown with a strike-through, and the event name is followed by `*` when the event class declares a deprecated field.
- The event class names are colored per package (see `color` in `config.yml`).
- Messages are available in English and Japanese, following the player's locale.

## Thanks

- I would like to express my gratitude to [石橋を叩いて壊すブログ](https://www.jias.jp/blog/) for producing and releasing `EventCatchAll.jar`, the original of this plugin.
