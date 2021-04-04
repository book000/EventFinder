package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;

public class OnInventoryEvent implements Listener {
    public OnInventoryEvent() {
    }

    @EventHandler
    public void onInventoryEvent(InventoryEvent event) {
        Main.showEvent(event);
    }
}