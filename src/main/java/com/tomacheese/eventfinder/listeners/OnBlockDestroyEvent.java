package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnBlockDestroyEvent implements Listener {
    public OnBlockDestroyEvent() {
    }

    @EventHandler
    public void onBlockDestroyEvent(BlockDestroyEvent event) {
        Main.showEvent(event);
    }
}