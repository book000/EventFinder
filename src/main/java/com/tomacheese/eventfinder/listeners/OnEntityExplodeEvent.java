package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class OnEntityExplodeEvent implements Listener {
    public OnEntityExplodeEvent() {
    }

    @EventHandler
    public void onEntityExplodeEvent(EntityExplodeEvent event) {
        Main.showEvent(event);
    }
}