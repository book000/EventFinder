package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class OnVehicleExitEvent implements Listener {
    public OnVehicleExitEvent() {
    }

    @EventHandler
    public void onVehicleExitEvent(VehicleExitEvent event) {
        Main.showEvent(event);
    }
}