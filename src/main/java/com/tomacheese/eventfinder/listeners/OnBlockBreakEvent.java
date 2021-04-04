package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnBlockBreakEvent implements Listener {
    public OnBlockBreakEvent() {
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        Main.showEvent(event);
    }
}