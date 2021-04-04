package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityPathfindEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityPathfindEvent implements Listener {
    public OnEntityPathfindEvent() {
    }

    @EventHandler
    public void onEntityPathfindEvent(EntityPathfindEvent event) {
        Main.showEvent(event);
    }
}