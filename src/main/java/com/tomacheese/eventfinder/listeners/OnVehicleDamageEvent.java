package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;

public class OnVehicleDamageEvent implements Listener {
    public OnVehicleDamageEvent() {
    }

    @EventHandler
    public void onVehicleDamageEvent(VehicleDamageEvent event) {
        Main.showEvent(event);
    }
}