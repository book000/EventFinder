package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;

public class OnBlockDispenseArmorEvent implements Listener {
    public OnBlockDispenseArmorEvent() {
    }

    @EventHandler
    public void onBlockDispenseArmorEvent(BlockDispenseArmorEvent event) {
        Main.showEvent(event);
    }
}