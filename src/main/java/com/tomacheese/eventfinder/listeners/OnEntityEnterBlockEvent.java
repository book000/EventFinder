package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEnterBlockEvent;

public class OnEntityEnterBlockEvent implements Listener {
    public OnEntityEnterBlockEvent() {
    }

    @EventHandler
    public void onEntityEnterBlockEvent(EntityEnterBlockEvent event) {
        Main.showEvent(event);
    }
}