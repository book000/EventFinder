package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;

public class OnEntityInteractEvent implements Listener {
    public OnEntityInteractEvent() {
    }

    @EventHandler
    public void onEntityInteractEvent(EntityInteractEvent event) {
        Main.showEvent(event);
    }
}