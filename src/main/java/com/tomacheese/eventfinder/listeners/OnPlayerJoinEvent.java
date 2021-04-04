package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinEvent implements Listener {
    public OnPlayerJoinEvent() {
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Main.showEvent(event);
    }
}