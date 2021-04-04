package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPlaceEvent;

public class OnEntityPlaceEvent implements Listener {
    public OnEntityPlaceEvent() {
    }

    @EventHandler
    public void onEntityPlaceEvent(EntityPlaceEvent event) {
        Main.showEvent(event);
    }
}