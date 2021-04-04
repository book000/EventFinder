package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerEvent;

public class OnServerEvent implements Listener {
    public OnServerEvent() {
    }

    @EventHandler
    public void onServerEvent(ServerEvent event) {
        Main.showEvent(event);
    }
}