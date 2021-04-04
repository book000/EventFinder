package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.MoistureChangeEvent;

public class OnMoistureChangeEvent implements Listener {
    public OnMoistureChangeEvent() {
    }

    @EventHandler
    public void onMoistureChangeEvent(MoistureChangeEvent event) {
        Main.showEvent(event);
    }
}