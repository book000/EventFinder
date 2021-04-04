package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;

public class OnEntityCreatePortalEvent implements Listener {
    public OnEntityCreatePortalEvent() {
    }

    @EventHandler
    public void onEntityCreatePortalEvent(EntityCreatePortalEvent event) {
        Main.showEvent(event);
    }
}