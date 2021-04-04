package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockShearEntityEvent;

public class OnBlockShearEntityEvent implements Listener {
    public OnBlockShearEntityEvent() {
    }

    @EventHandler
    public void onBlockShearEntityEvent(BlockShearEntityEvent event) {
        Main.showEvent(event);
    }
}