package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;

public class OnVehicleBlockCollisionEvent implements Listener {
    public OnVehicleBlockCollisionEvent() {
    }

    @EventHandler
    public void onVehicleBlockCollisionEvent(VehicleBlockCollisionEvent event) {
        Main.showEvent(event);
    }
}