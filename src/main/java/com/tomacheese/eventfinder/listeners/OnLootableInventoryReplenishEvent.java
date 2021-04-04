package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.loottable.LootableInventoryReplenishEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnLootableInventoryReplenishEvent implements Listener {
    public OnLootableInventoryReplenishEvent() {
    }

    @EventHandler
    public void onLootableInventoryReplenishEvent(LootableInventoryReplenishEvent event) {
        Main.showEvent(event);
    }
}