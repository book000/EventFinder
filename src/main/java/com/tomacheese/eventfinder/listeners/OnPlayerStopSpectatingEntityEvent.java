package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerStopSpectatingEntityEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerStopSpectatingEntityEvent implements Listener {
    public OnPlayerStopSpectatingEntityEvent() {
    }

    @EventHandler
    public void onPlayerStopSpectatingEntityEvent(PlayerStopSpectatingEntityEvent event) {
        Main.showEvent(event);
    }
}