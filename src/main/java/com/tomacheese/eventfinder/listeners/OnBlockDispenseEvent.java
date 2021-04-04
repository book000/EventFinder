package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class OnBlockDispenseEvent implements Listener {
    public OnBlockDispenseEvent() {
    }

    @EventHandler
    public void onBlockDispenseEvent(BlockDispenseEvent event) {
        Main.showEvent(event);
    }
}