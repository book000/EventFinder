package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class OnEntityCombustEvent implements Listener {
    public OnEntityCombustEvent() {
    }

    @EventHandler
    public void onEntityCombustEvent(EntityCombustEvent event) {
        Main.showEvent(event);
    }
}