package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityTeleportEndGatewayEvent implements Listener {
    public OnEntityTeleportEndGatewayEvent() {
    }

    @EventHandler
    public void onEntityTeleportEndGatewayEvent(EntityTeleportEndGatewayEvent event) {
        Main.showEvent(event);
    }
}