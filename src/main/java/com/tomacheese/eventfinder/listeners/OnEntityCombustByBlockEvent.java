package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;

public class OnEntityCombustByBlockEvent implements Listener {
    public OnEntityCombustByBlockEvent() {
    }

    @EventHandler
    public void onEntityCombustByBlockEvent(EntityCombustByBlockEvent event) {
        Main.showEvent(event);
    }
}