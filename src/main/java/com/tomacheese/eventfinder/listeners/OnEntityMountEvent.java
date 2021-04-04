package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class OnEntityMountEvent implements Listener {
    public OnEntityMountEvent() {
    }

    @EventHandler
    public void onEntityMountEvent(EntityMountEvent event) {
        Main.showEvent(event);
    }
}