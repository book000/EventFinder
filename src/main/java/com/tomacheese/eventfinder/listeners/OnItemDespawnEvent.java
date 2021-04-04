package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public class OnItemDespawnEvent implements Listener {
    public OnItemDespawnEvent() {
    }

    @EventHandler
    public void onItemDespawnEvent(ItemDespawnEvent event) {
        Main.showEvent(event);
    }
}