package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

public class OnServerLoadEvent implements Listener {
    public OnServerLoadEvent() {
    }

    @EventHandler
    public void onServerLoadEvent(ServerLoadEvent event) {
        Main.showEvent(event);
    }
}