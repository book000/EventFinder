package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class OnBlockIgniteEvent implements Listener {
    public OnBlockIgniteEvent() {
    }

    @EventHandler
    public void onBlockIgniteEvent(BlockIgniteEvent event) {
        Main.showEvent(event);
    }
}