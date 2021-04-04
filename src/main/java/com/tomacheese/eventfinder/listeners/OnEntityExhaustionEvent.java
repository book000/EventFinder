package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExhaustionEvent;

public class OnEntityExhaustionEvent implements Listener {
    public OnEntityExhaustionEvent() {
    }

    @EventHandler
    public void onEntityExhaustionEvent(EntityExhaustionEvent event) {
        Main.showEvent(event);
    }
}