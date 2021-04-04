package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class OnEntityTeleportEvent implements Listener {
    public OnEntityTeleportEvent() {
    }

    @EventHandler
    public void onEntityTeleportEvent(EntityTeleportEvent event) {
        Main.showEvent(event);
    }
}