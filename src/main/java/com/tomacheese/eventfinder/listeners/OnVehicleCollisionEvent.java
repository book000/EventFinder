package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCollisionEvent;

public class OnVehicleCollisionEvent implements Listener {
    public OnVehicleCollisionEvent() {
    }

    @EventHandler
    public void onVehicleCollisionEvent(VehicleCollisionEvent event) {
        Main.showEvent(event);
    }
}