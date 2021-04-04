package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.RemoteServerCommandEvent;

public class OnRemoteServerCommandEvent implements Listener {
    public OnRemoteServerCommandEvent() {
    }

    @EventHandler
    public void onRemoteServerCommandEvent(RemoteServerCommandEvent event) {
        Main.showEvent(event);
    }
}