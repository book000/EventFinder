package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerConnectionCloseEvent implements Listener {
    public OnPlayerConnectionCloseEvent() {
    }

    @EventHandler
    public void onPlayerConnectionCloseEvent(PlayerConnectionCloseEvent event) {
        Main.showEvent(event);
    }
}