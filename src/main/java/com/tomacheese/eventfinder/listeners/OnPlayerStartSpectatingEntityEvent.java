package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerStartSpectatingEntityEvent implements Listener {
    public OnPlayerStartSpectatingEntityEvent() {
    }

    @EventHandler
    public void onPlayerStartSpectatingEntityEvent(PlayerStartSpectatingEntityEvent event) {
        Main.showEvent(event);
    }
}