package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class OnPlayerChatEvent implements Listener {
    public OnPlayerChatEvent() {
    }

    @EventHandler
    public void onPlayerChatEvent(PlayerChatEvent event) {
        Main.showEvent(event);
    }
}