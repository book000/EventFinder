package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.inventory.PrepareResultEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPrepareResultEvent implements Listener {
    public OnPrepareResultEvent() {
    }

    @EventHandler
    public void onPrepareResultEvent(PrepareResultEvent event) {
        Main.showEvent(event);
    }
}