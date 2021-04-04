package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonEvent;

public class OnBlockPistonEvent implements Listener {
    public OnBlockPistonEvent() {
    }

    @EventHandler
    public void onBlockPistonEvent(BlockPistonEvent event) {
        Main.showEvent(event);
    }
}