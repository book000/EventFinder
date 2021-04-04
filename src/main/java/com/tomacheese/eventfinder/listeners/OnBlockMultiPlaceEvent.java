package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockMultiPlaceEvent;

public class OnBlockMultiPlaceEvent implements Listener {
    public OnBlockMultiPlaceEvent() {
    }

    @EventHandler
    public void onBlockMultiPlaceEvent(BlockMultiPlaceEvent event) {
        Main.showEvent(event);
    }
}