package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

public class OnVehicleDestroyEvent implements Listener {
    public OnVehicleDestroyEvent() {
    }

    @EventHandler
    public void onVehicleDestroyEvent(VehicleDestroyEvent event) {
        Main.showEvent(event);
    }
}