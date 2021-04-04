package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class OnCraftItemEvent implements Listener {
    public OnCraftItemEvent() {
    }

    @EventHandler
    public void onCraftItemEvent(CraftItemEvent event) {
        Main.showEvent(event);
    }
}