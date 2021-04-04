package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.block.BlockFailedDispenseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnBlockFailedDispenseEvent implements Listener {
    public OnBlockFailedDispenseEvent() {
    }

    @EventHandler
    public void onBlockFailedDispenseEvent(BlockFailedDispenseEvent event) {
        Main.showEvent(event);
    }
}