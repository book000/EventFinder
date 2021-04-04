package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

public class OnItemSpawnEvent implements Listener {
    public OnItemSpawnEvent() {
    }

    @EventHandler
    public void onItemSpawnEvent(ItemSpawnEvent event) {
        Main.showEvent(event);
    }
}