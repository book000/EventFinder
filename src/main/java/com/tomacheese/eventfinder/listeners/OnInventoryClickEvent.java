package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnInventoryClickEvent implements Listener {
    public OnInventoryClickEvent() {
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Main.showEvent(event);
    }
}