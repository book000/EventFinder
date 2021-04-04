package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;

public class OnHangingPlaceEvent implements Listener {
    public OnHangingPlaceEvent() {
    }

    @EventHandler
    public void onHangingPlaceEvent(HangingPlaceEvent event) {
        Main.showEvent(event);
    }
}