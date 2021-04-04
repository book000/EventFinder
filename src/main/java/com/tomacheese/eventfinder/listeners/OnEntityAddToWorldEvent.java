package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityAddToWorldEvent implements Listener {
    public OnEntityAddToWorldEvent() {
    }

    @EventHandler
    public void onEntityAddToWorldEvent(EntityAddToWorldEvent event) {
        Main.showEvent(event);
    }
}