package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;

public class OnInventoryCreativeEvent implements Listener {
    public OnInventoryCreativeEvent() {
    }

    @EventHandler
    public void onInventoryCreativeEvent(InventoryCreativeEvent event) {
        Main.showEvent(event);
    }
}