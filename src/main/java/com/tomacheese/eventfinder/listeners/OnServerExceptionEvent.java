package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.server.ServerExceptionEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnServerExceptionEvent implements Listener {
    public OnServerExceptionEvent() {
    }

    @EventHandler
    public void onServerExceptionEvent(ServerExceptionEvent event) {
        Main.showEvent(event);
    }
}