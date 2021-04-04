package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleUpdateEvent;

public class OnVehicleUpdateEvent implements Listener {
    public OnVehicleUpdateEvent() {
    }

    @EventHandler
    public void onVehicleUpdateEvent(VehicleUpdateEvent event) {
        Main.showEvent(event);
    }
}