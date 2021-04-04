package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class OnLeavesDecayEvent implements Listener {
    public OnLeavesDecayEvent() {
    }

    @EventHandler
    public void onLeavesDecayEvent(LeavesDecayEvent event) {
        Main.showEvent(event);
    }
}