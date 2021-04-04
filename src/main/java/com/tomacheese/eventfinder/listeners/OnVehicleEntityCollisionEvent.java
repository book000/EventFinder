package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class OnVehicleEntityCollisionEvent implements Listener {
    public OnVehicleEntityCollisionEvent() {
    }

    @EventHandler
    public void onVehicleEntityCollisionEvent(VehicleEntityCollisionEvent event) {
        Main.showEvent(event);
    }
}