package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServiceEvent;

public class OnServiceEvent implements Listener {
    public OnServiceEvent() {
    }

    @EventHandler
    public void onServiceEvent(ServiceEvent event) {
        Main.showEvent(event);
    }
}