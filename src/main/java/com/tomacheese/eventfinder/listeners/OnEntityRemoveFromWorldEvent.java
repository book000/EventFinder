package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityRemoveFromWorldEvent implements Listener {
    public OnEntityRemoveFromWorldEvent() {
    }

    @EventHandler
    public void onEntityRemoveFromWorldEvent(EntityRemoveFromWorldEvent event) {
        Main.showEvent(event);
    }
}