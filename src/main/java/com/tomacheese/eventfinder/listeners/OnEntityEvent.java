package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEvent;

public class OnEntityEvent implements Listener {
    public OnEntityEvent() {
    }

    @EventHandler
    public void onEntityEvent(EntityEvent event) {
        Main.showEvent(event);
    }
}