package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerUnleashEntityEvent;

public class OnPlayerUnleashEntityEvent implements Listener {
    public OnPlayerUnleashEntityEvent() {
    }

    @EventHandler
    public void onPlayerUnleashEntityEvent(PlayerUnleashEntityEvent event) {
        Main.showEvent(event);
    }
}