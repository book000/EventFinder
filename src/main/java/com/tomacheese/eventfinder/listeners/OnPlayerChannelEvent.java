package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChannelEvent;

public class OnPlayerChannelEvent implements Listener {
    public OnPlayerChannelEvent() {
    }

    @EventHandler
    public void onPlayerChannelEvent(PlayerChannelEvent event) {
        Main.showEvent(event);
    }
}