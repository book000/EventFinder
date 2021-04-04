package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;

public class OnVehicleCreateEvent implements Listener {
    public OnVehicleCreateEvent() {
    }

    @EventHandler
    public void onVehicleCreateEvent(VehicleCreateEvent event) {
        Main.showEvent(event);
    }
}