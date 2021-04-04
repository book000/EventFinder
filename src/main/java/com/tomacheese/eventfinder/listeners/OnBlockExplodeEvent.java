package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class OnBlockExplodeEvent implements Listener {
    public OnBlockExplodeEvent() {
    }

    @EventHandler
    public void onBlockExplodeEvent(BlockExplodeEvent event) {
        Main.showEvent(event);
    }
}