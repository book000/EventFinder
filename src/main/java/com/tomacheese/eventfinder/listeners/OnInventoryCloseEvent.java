package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class OnInventoryCloseEvent implements Listener {
    public OnInventoryCloseEvent() {
    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {
        Main.showEvent(event);
    }
}