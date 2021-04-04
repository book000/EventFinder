package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class OnEntityDismountEvent implements Listener {
    public OnEntityDismountEvent() {
    }

    @EventHandler
    public void onEntityDismountEvent(EntityDismountEvent event) {
        Main.showEvent(event);
    }
}