package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class OnVehicleMoveEvent implements Listener {
    public OnVehicleMoveEvent() {
    }

    @EventHandler
    public void onVehicleMoveEvent(VehicleMoveEvent event) {
        Main.showEvent(event);
    }
}