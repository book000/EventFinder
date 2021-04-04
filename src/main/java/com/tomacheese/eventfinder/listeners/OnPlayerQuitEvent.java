package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerQuitEvent implements Listener {
    public OnPlayerQuitEvent() {
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Main.showEvent(event);
    }
}