package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;

public class OnEntityDamageByBlockEvent implements Listener {
    public OnEntityDamageByBlockEvent() {
    }

    @EventHandler
    public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event) {
        Main.showEvent(event);
    }
}