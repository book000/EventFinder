package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class OnInventoryDragEvent implements Listener {
    public OnInventoryDragEvent() {
    }

    @EventHandler
    public void onInventoryDragEvent(InventoryDragEvent event) {
        Main.showEvent(event);
    }
}