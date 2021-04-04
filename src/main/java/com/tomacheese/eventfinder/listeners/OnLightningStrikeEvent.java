package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class OnLightningStrikeEvent implements Listener {
    public OnLightningStrikeEvent() {
    }

    @EventHandler
    public void onLightningStrikeEvent(LightningStrikeEvent event) {
        Main.showEvent(event);
    }
}