package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class OnVehicleEnterEvent implements Listener {
    public OnVehicleEnterEvent() {
    }

    @EventHandler
    public void onVehicleEnterEvent(VehicleEnterEvent event) {
        Main.showEvent(event);
    }
}