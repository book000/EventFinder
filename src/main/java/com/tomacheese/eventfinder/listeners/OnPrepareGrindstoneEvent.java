package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.inventory.PrepareGrindstoneEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPrepareGrindstoneEvent implements Listener {
    public OnPrepareGrindstoneEvent() {
    }

    @EventHandler
    public void onPrepareGrindstoneEvent(PrepareGrindstoneEvent event) {
        Main.showEvent(event);
    }
}