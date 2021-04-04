package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;

public class OnBrewEvent implements Listener {
    public OnBrewEvent() {
    }

    @EventHandler
    public void onBrewEvent(BrewEvent event) {
        Main.showEvent(event);
    }
}