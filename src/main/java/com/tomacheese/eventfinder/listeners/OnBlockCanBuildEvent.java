package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;

public class OnBlockCanBuildEvent implements Listener {
    public OnBlockCanBuildEvent() {
    }

    @EventHandler
    public void onBlockCanBuildEvent(BlockCanBuildEvent event) {
        Main.showEvent(event);
    }
}