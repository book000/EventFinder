package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;

public class OnFurnaceExtractEvent implements Listener {
    public OnFurnaceExtractEvent() {
    }

    @EventHandler
    public void onFurnaceExtractEvent(FurnaceExtractEvent event) {
        Main.showEvent(event);
    }
}