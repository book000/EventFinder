package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class OnBlockRedstoneEvent implements Listener {
    public OnBlockRedstoneEvent() {
    }

    @EventHandler
    public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
        Main.showEvent(event);
    }
}