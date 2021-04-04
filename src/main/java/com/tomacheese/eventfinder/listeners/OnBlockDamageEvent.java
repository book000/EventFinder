package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class OnBlockDamageEvent implements Listener {
    public OnBlockDamageEvent() {
    }

    @EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event) {
        Main.showEvent(event);
    }
}