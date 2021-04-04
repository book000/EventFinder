package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class OnPlayerLoginEvent implements Listener {
    public OnPlayerLoginEvent() {
    }

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event) {
        Main.showEvent(event);
    }
}