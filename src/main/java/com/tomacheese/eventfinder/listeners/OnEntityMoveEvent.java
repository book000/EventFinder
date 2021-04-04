package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityMoveEvent implements Listener {
    public OnEntityMoveEvent() {
    }

    @EventHandler
    public void onEntityMoveEvent(EntityMoveEvent event) {
        Main.showEvent(event);
    }
}