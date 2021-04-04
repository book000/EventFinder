package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public class OnEntityBreedEvent implements Listener {
    public OnEntityBreedEvent() {
    }

    @EventHandler
    public void onEntityBreedEvent(EntityBreedEvent event) {
        Main.showEvent(event);
    }
}