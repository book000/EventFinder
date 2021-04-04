package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class OnServerListPingEvent implements Listener {
    public OnServerListPingEvent() {
    }

    @EventHandler
    public void onServerListPingEvent(ServerListPingEvent event) {
        Main.showEvent(event);
    }
}