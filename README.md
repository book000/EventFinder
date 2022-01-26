# EventFinder

[日本語の README はこちらから](README-ja.md)

This is a plugin for PaperMC 1.16.5 or later that displays events that have occurred in the chat.  
The code is modified and improved from the code in [発生したイベントを画面に表示するプラグインを作った](https://www.jias.jp/blog/?84) of the "石橋を叩いて壊すブログ".

## Installation

Download the jar file from [Releases](https://github.com/book000/EventFinder/releases) and move it in the `plugins` directory.

## Commands

- `/event <add|hide> <EventNamePattern>`: Add `EventNamePattern` to the hide condition.
- `/event <del|remove|show> <EventNamePattern>`: Removes `EventNamePattern` from the hiding condition.
- `/event filter <FilterString>`: Display only event information that includes `FilterString`.
- `/event list`: Displays a list of hidden conditions.
- `/event save`: Saves the hidden conditions to a file.
- `/event load`: Load the hidden conditions from a file.

## Specifications

- It is highly recommended for use in flat worlds.
- Some of the events are disabled from the beginning because they are displayed in large numbers.
- Deprecated events are indicated by a strike-through line.
- The methods of the class show the return value of methods starting with `get` or `is`. Except when it contains `Handler`.

## Thanks

- I would like to express my gratitude to [石橋を叩いて壊すブログ](https://www.jias.jp/blog/) for producing and releasing `EventCatchAll.jar`, the original of this plugin.
