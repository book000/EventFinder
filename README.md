# EventFinder

[日本語の README はこちら](README-ja.md)

EventFinder is a PaperMC plugin (1.16.5 or later) that displays the events occurring on the server in the chat. A single jar supports every Paper version from 1.16.5 to the latest, and the events are detected from the running server.

The code is modified and improved from the code in [発生したイベントを画面に表示するプラグインを作った](https://www.jias.jp/blog/?84) of the "石橋を叩いて壊すブログ".

## Installation

Download the jar file from [Releases](https://github.com/book000/EventFinder/releases) and move it into the server's `plugins` directory.

## Commands

The `/event` command is available to operators by default.

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
- Some events that occur in large numbers are hidden from the beginning (see `hidePattern` in `config.yml`).
- Each event is shown as its class name followed by the values returned by its `get*` and `is*` methods (methods whose name contains `Handler` are excluded). Hover over the event name to see the class and its methods.
- Cancelled events are shown with a strike-through, and the event name is followed by `*` when the event class declares a deprecated field.
- The event class names are colored per package (see `color` in `config.yml`).
- Messages are available in English and Japanese, following the player's locale.

## Thanks

- I would like to express my gratitude to [石橋を叩いて壊すブログ](https://www.jias.jp/blog/) for producing and releasing `EventCatchAll.jar`, the original of this plugin.
