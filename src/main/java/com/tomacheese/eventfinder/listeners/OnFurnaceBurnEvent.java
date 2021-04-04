package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class OnFurnaceBurnEvent implements Listener {
    public OnFurnaceBurnEvent() {
    }

    @EventHandler
    public void onFurnaceBurnEvent(FurnaceBurnEvent event) {
        Main.showEvent(event);
    }
}