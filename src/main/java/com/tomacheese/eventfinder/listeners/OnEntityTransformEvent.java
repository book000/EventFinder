package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTransformEvent;

public class OnEntityTransformEvent implements Listener {
    public OnEntityTransformEvent() {
    }

    @EventHandler
    public void onEntityTransformEvent(EntityTransformEvent event) {
        Main.showEvent(event);
    }
}