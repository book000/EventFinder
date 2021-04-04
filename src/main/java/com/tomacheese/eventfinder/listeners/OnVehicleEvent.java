package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEvent;

public class OnVehicleEvent implements Listener {
    public OnVehicleEvent() {
    }

    @EventHandler
    public void onVehicleEvent(VehicleEvent event) {
        Main.showEvent(event);
    }
}