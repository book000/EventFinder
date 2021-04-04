package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class OnPlayerPortalEvent implements Listener {
    public OnPlayerPortalEvent() {
    }

    @EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent event) {
        Main.showEvent(event);
    }
}