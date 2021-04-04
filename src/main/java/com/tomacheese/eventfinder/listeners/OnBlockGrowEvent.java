package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class OnBlockGrowEvent implements Listener {
    public OnBlockGrowEvent() {
    }

    @EventHandler
    public void onBlockGrowEvent(BlockGrowEvent event) {
        Main.showEvent(event);
    }
}