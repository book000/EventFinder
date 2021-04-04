package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;

public class OnInventoryInteractEvent implements Listener {
    public OnInventoryInteractEvent() {
    }

    @EventHandler
    public void onInventoryInteractEvent(InventoryInteractEvent event) {
        Main.showEvent(event);
    }
}