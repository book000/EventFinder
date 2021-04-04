package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class OnInventoryOpenEvent implements Listener {
    public OnInventoryOpenEvent() {
    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {
        Main.showEvent(event);
    }
}