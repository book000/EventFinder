package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class OnBlockFormEvent implements Listener {
    public OnBlockFormEvent() {
    }

    @EventHandler
    public void onBlockFormEvent(BlockFormEvent event) {
        Main.showEvent(event);
    }
}