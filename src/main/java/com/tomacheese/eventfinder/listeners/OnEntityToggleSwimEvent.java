package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleSwimEvent;

public class OnEntityToggleSwimEvent implements Listener {
    public OnEntityToggleSwimEvent() {
    }

    @EventHandler
    public void onEntityToggleSwimEvent(EntityToggleSwimEvent event) {
        Main.showEvent(event);
    }
}