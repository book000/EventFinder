package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;

public class OnHangingBreakEvent implements Listener {
    public OnHangingBreakEvent() {
    }

    @EventHandler
    public void onHangingBreakEvent(HangingBreakEvent event) {
        Main.showEvent(event);
    }
}