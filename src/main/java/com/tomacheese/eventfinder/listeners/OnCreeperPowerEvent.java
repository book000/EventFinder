package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreeperPowerEvent;

public class OnCreeperPowerEvent implements Listener {
    public OnCreeperPowerEvent() {
    }

    @EventHandler
    public void onCreeperPowerEvent(CreeperPowerEvent event) {
        Main.showEvent(event);
    }
}