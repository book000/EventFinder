package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class OnPlayerTeleportEvent implements Listener {
    public OnPlayerTeleportEvent() {
    }

    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
        Main.showEvent(event);
    }
}