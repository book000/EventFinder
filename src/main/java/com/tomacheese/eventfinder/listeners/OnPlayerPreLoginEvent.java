package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPreLoginEvent;

public class OnPlayerPreLoginEvent implements Listener {
    public OnPlayerPreLoginEvent() {
    }

    @EventHandler
    public void onPlayerPreLoginEvent(PlayerPreLoginEvent event) {
        Main.showEvent(event);
    }
}