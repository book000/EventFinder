package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;

public class OnPrepareSmithingEvent implements Listener {
    public OnPrepareSmithingEvent() {
    }

    @EventHandler
    public void onPrepareSmithingEvent(PrepareSmithingEvent event) {
        Main.showEvent(event);
    }
}