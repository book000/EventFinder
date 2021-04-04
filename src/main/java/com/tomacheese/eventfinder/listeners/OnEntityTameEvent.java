package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;

public class OnEntityTameEvent implements Listener {
    public OnEntityTameEvent() {
    }

    @EventHandler
    public void onEntityTameEvent(EntityTameEvent event) {
        Main.showEvent(event);
    }
}