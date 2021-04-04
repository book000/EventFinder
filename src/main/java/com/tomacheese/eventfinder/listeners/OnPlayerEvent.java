package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

public class OnPlayerEvent implements Listener {
    public OnPlayerEvent() {
    }

    @EventHandler
    public void onPlayerEvent(PlayerEvent event) {
        Main.showEvent(event);
    }
}