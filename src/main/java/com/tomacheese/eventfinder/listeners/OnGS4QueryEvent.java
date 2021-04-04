package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.server.GS4QueryEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnGS4QueryEvent implements Listener {
    public OnGS4QueryEvent() {
    }

    @EventHandler
    public void onGS4QueryEvent(GS4QueryEvent event) {
        Main.showEvent(event);
    }
}