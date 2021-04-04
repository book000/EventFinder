package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalExitEvent;

public class OnEntityPortalExitEvent implements Listener {
    public OnEntityPortalExitEvent() {
    }

    @EventHandler
    public void onEntityPortalExitEvent(EntityPortalExitEvent event) {
        Main.showEvent(event);
    }
}