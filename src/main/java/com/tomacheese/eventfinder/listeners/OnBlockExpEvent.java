package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExpEvent;

public class OnBlockExpEvent implements Listener {
    public OnBlockExpEvent() {
    }

    @EventHandler
    public void onBlockExpEvent(BlockExpEvent event) {
        Main.showEvent(event);
    }
}