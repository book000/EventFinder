package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingEvent;

public class OnHangingEvent implements Listener {
    public OnHangingEvent() {
    }

    @EventHandler
    public void onHangingEvent(HangingEvent event) {
        Main.showEvent(event);
    }
}