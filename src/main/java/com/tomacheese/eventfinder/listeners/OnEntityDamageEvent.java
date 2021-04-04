package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnEntityDamageEvent implements Listener {
    public OnEntityDamageEvent() {
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        Main.showEvent(event);
    }
}