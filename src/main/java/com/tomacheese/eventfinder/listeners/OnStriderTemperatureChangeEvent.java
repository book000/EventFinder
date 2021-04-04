package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.StriderTemperatureChangeEvent;

public class OnStriderTemperatureChangeEvent implements Listener {
    public OnStriderTemperatureChangeEvent() {
    }

    @EventHandler
    public void onStriderTemperatureChangeEvent(StriderTemperatureChangeEvent event) {
        Main.showEvent(event);
    }
}