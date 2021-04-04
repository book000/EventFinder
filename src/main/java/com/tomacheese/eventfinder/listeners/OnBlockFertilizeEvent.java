package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFertilizeEvent;

public class OnBlockFertilizeEvent implements Listener {
    public OnBlockFertilizeEvent() {
    }

    @EventHandler
    public void onBlockFertilizeEvent(BlockFertilizeEvent event) {
        Main.showEvent(event);
    }
}