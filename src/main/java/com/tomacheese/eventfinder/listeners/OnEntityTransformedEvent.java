package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityTransformedEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityTransformedEvent implements Listener {
    public OnEntityTransformedEvent() {
    }

    @EventHandler
    public void onEntityTransformedEvent(EntityTransformedEvent event) {
        Main.showEvent(event);
    }
}