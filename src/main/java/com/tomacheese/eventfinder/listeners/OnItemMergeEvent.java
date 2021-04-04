package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;

public class OnItemMergeEvent implements Listener {
    public OnItemMergeEvent() {
    }

    @EventHandler
    public void onItemMergeEvent(ItemMergeEvent event) {
        Main.showEvent(event);
    }
}