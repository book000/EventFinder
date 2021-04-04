package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class OnBlockFadeEvent implements Listener {
    public OnBlockFadeEvent() {
    }

    @EventHandler
    public void onBlockFadeEvent(BlockFadeEvent event) {
        Main.showEvent(event);
    }
}