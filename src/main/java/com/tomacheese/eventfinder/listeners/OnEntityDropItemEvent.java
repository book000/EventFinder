package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;

public class OnEntityDropItemEvent implements Listener {
    public OnEntityDropItemEvent() {
    }

    @EventHandler
    public void onEntityDropItemEvent(EntityDropItemEvent event) {
        Main.showEvent(event);
    }
}