package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

public class OnPlayerChatTabCompleteEvent implements Listener {
    public OnPlayerChatTabCompleteEvent() {
    }

    @EventHandler
    public void onPlayerChatTabCompleteEvent(PlayerChatTabCompleteEvent event) {
        Main.showEvent(event);
    }
}