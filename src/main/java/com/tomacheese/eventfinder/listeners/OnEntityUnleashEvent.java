package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityUnleashEvent;

public class OnEntityUnleashEvent implements Listener {
    public OnEntityUnleashEvent() {
    }

    @EventHandler
    public void onEntityUnleashEvent(EntityUnleashEvent event) {
        Main.showEvent(event);
    }
}