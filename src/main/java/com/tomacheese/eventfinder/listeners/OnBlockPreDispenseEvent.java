package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.block.BlockPreDispenseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnBlockPreDispenseEvent implements Listener {
    public OnBlockPreDispenseEvent() {
    }

    @EventHandler
    public void onBlockPreDispenseEvent(BlockPreDispenseEvent event) {
        Main.showEvent(event);
    }
}