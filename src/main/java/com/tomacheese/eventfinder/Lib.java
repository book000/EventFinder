package com.tomacheese.eventfinder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Locale;

public class Lib {
    public static void sendMessage(CommandSender sender, I18nMsgType msgType, TextColor color, Object... arguments) {
        Player player = sender instanceof Player ? (Player) sender : null;
        Style style = color != null ? Style.style(color) : Style.empty();
        sender.sendMessage(Component.text("[EventFinder] ").append(
            Component.text(Lib.getMessage(player, msgType, arguments), style)
        ));
    }

    public static String getMessage(Player player, I18nMsgType msgType, Object... arguments) {
        String localeName = (player != null ? player.locale() : Locale.getDefault()).toLanguageTag();
        String filename = "/i18n/" + localeName + ".yml";
        try (InputStream is = Main.class.getResourceAsStream(filename)) {
            if (is == null) {
                return MessageFormat.format(msgType.getDefaultMessage(), arguments);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                YamlConfiguration yml = YamlConfiguration.loadConfiguration(br);
                if (!yml.contains(msgType.name())) {
                    return MessageFormat.format(msgType.getDefaultMessage(), arguments);
                }
                String message = yml.getString(msgType.name());
                if (message == null) {
                    return msgType.getDefaultMessage();
                }
                return MessageFormat.format(message, arguments);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MessageFormat.format(msgType.getDefaultMessage(), arguments);
    }
}
