package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;

public class OnHangingBreakByEntityEvent implements Listener {
    public OnHangingBreakByEntityEvent() {
    }

    @EventHandler
    public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {
        Main.showEvent(event);
    }
}