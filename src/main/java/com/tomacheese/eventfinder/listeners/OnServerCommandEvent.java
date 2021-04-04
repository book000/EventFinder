package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class OnServerCommandEvent implements Listener {
    public OnServerCommandEvent() {
    }

    @EventHandler
    public void onServerCommandEvent(ServerCommandEvent event) {
        Main.showEvent(event);
    }
}