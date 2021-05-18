package com.tomacheese.eventfinder;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Commands implements CommandExecutor {
    Main main;
    Map<String, CmdFunc> commands = new HashMap<>();

    {
        commands.put("load", this::load);

        commands.put("add", this::hide);
        commands.put("hide", this::hide);

        commands.put("del", this::show);
        commands.put("remove", this::show);
        commands.put("show", this::show);

        commands.put("toggle", this::toggle);

        commands.put("filter", this::filter);

        commands.put("list", this::list);

        commands.put("save", this::save);
    }

    public Commands(Main main) {
        this.main = main;
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, String[] args) {
        if (args.length == 0) {
            Lib.sendMessage(sender, I18nMsgType.CommandArgumentRequired, NamedTextColor.RED, String.join(", ", commands.keySet()));
            return true;
        }

        if (commands.containsKey(args[0])) {
            commands.get(args[0]).execute(sender, args);
            return true;
        }

        Lib.sendMessage(sender, I18nMsgType.CommandArgumentIncorrect, NamedTextColor.RED, String.join(", ", commands.keySet()));
        return false;
    }

    void load(CommandSender sender, String[] args) {
        main.loadHidePattern();
        Lib.sendMessage(sender, I18nMsgType.LoadedHideConfig, NamedTextColor.GREEN);
        list(sender, args);
    }

    void hide(CommandSender sender, String[] args) {
        if (args.length == 2) {
            // single
            String pattern = args[1];
            main.addHidePattern(pattern);
            Lib.sendMessage(sender, I18nMsgType.AddSingleHide, NamedTextColor.GREEN, pattern);
            return;
        }
        int count = 0;
        for (int i = 1; i < args.length; i++) {
            if (main.addHidePattern(args[i])) {
                count++;
            }
        }

        Lib.sendMessage(sender, I18nMsgType.AddMultipleHide, NamedTextColor.GREEN, count);

        main.conf.set(Main.CONF_HIDE_PATTERN, Main.hidePattern);
        main.saveConfig();
        Lib.sendMessage(sender, I18nMsgType.SaveHideConfig, NamedTextColor.GREEN);
    }

    void show(CommandSender sender, String[] args) {
        if (args.length == 2) {
            // single
            String pattern = args[1];
            main.removeHidePattern(pattern);
            Lib.sendMessage(sender, I18nMsgType.RemoveSingleHide, NamedTextColor.GREEN, pattern);
            return;
        }
        int count = 0;
        for (int i = 1; i < args.length; i++) {
            if (main.removeHidePattern(args[i])) {
                count++;
            }
        }

        Lib.sendMessage(sender, I18nMsgType.RemoveMultipleHide, NamedTextColor.GREEN, count);

        main.conf.set(Main.CONF_HIDE_PATTERN, Main.hidePattern);
        main.saveConfig();
        Lib.sendMessage(sender, I18nMsgType.SaveHideConfig, NamedTextColor.GREEN);
    }

    void toggle(CommandSender sender, String[] args) {
        if (args.length != 2) {
            Lib.sendMessage(sender, I18nMsgType.TooManyArguments, NamedTextColor.RED);
        }
        if (Main.hidePattern.contains(args[1].toLowerCase())) {
            main.removeHidePattern(args[1]);
            Lib.sendMessage(sender, I18nMsgType.RemoveSingleHide, NamedTextColor.GREEN, args[1]);
        } else {
            main.addHidePattern(args[1]);
            Lib.sendMessage(sender, I18nMsgType.AddSingleHide, NamedTextColor.GREEN, args[1]);
        }

        main.conf.set(Main.CONF_HIDE_PATTERN, Main.hidePattern);
        main.saveConfig();
        Lib.sendMessage(sender, I18nMsgType.SaveHideConfig, NamedTextColor.GREEN);
    }

    void filter(CommandSender sender, String[] args) {
        if (args.length == 1) {
            main.setFilter(null);
            Lib.sendMessage(sender, I18nMsgType.ResetFilter, NamedTextColor.GREEN);
            return;
        }
        main.setFilter(Arrays.stream(args).skip(1).collect(Collectors.joining(" ")));
        Lib.sendMessage(sender, I18nMsgType.SetFilter, NamedTextColor.GREEN, Arrays.stream(args).skip(1).collect(Collectors.joining(" ")));
    }

    void list(CommandSender sender, String[] args) {
        Lib.sendMessage(sender, I18nMsgType.HidingConditionCount, NamedTextColor.GREEN, Main.hidePattern.size());
        for (String pattern : Main.hidePattern) {
            sender.sendMessage(pattern);
        }
    }

    void save(CommandSender sender, String[] args) {
        main.conf.set(Main.CONF_HIDE_PATTERN, Main.hidePattern);
        main.saveConfig();
        Lib.sendMessage(sender, I18nMsgType.SaveHideConfig, NamedTextColor.GREEN);
    }

    @FunctionalInterface
    interface CmdFunc {
        void execute(CommandSender sender, String[] args);
    }
}
