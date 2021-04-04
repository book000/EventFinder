package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class OnPlayerResourcePackStatusEvent implements Listener {
    public OnPlayerResourcePackStatusEvent() {
    }

    @EventHandler
    public void onPlayerResourcePackStatusEvent(PlayerResourcePackStatusEvent event) {
        Main.showEvent(event);
    }
}