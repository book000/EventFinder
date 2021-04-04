package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;

public class OnEntityAirChangeEvent implements Listener {
    public OnEntityAirChangeEvent() {
    }

    @EventHandler
    public void onEntityAirChangeEvent(EntityAirChangeEvent event) {
        Main.showEvent(event);
    }
}