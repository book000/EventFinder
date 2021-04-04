package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEnterEvent;

public class OnEntityPortalEnterEvent implements Listener {
    public OnEntityPortalEnterEvent() {
    }

    @EventHandler
    public void onEntityPortalEnterEvent(EntityPortalEnterEvent event) {
        Main.showEvent(event);
    }
}