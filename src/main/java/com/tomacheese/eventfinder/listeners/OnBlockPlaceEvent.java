package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnBlockPlaceEvent implements Listener {
    public OnBlockPlaceEvent() {
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        Main.showEvent(event);
    }
}