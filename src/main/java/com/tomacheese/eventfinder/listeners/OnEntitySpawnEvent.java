package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class OnEntitySpawnEvent implements Listener {
    public OnEntitySpawnEvent() {
    }

    @EventHandler
    public void onEntitySpawnEvent(EntitySpawnEvent event) {
        Main.showEvent(event);
    }
}