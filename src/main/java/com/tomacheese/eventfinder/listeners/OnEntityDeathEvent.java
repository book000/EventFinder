package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class OnEntityDeathEvent implements Listener {
    public OnEntityDeathEvent() {
    }

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {
        Main.showEvent(event);
    }
}