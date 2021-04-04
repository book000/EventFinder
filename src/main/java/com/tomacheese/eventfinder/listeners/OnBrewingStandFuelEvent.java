package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewingStandFuelEvent;

public class OnBrewingStandFuelEvent implements Listener {
    public OnBrewingStandFuelEvent() {
    }

    @EventHandler
    public void onBrewingStandFuelEvent(BrewingStandFuelEvent event) {
        Main.showEvent(event);
    }
}