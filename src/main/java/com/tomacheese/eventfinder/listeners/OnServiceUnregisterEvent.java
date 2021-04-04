package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServiceUnregisterEvent;

public class OnServiceUnregisterEvent implements Listener {
    public OnServiceUnregisterEvent() {
    }

    @EventHandler
    public void onServiceUnregisterEvent(ServiceUnregisterEvent event) {
        Main.showEvent(event);
    }
}