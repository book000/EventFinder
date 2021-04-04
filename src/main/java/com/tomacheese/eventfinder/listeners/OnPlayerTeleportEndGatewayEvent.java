package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerTeleportEndGatewayEvent implements Listener {
    public OnPlayerTeleportEndGatewayEvent() {
    }

    @EventHandler
    public void onPlayerTeleportEndGatewayEvent(PlayerTeleportEndGatewayEvent event) {
        Main.showEvent(event);
    }
}