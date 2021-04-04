package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCookEvent;

public class OnBlockCookEvent implements Listener {
    public OnBlockCookEvent() {
    }

    @EventHandler
    public void onBlockCookEvent(BlockCookEvent event) {
        Main.showEvent(event);
    }
}