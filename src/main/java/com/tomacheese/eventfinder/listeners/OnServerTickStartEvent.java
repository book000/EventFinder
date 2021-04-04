package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnServerTickStartEvent implements Listener {
    public OnServerTickStartEvent() {
    }

    @EventHandler
    public void onServerTickStartEvent(ServerTickStartEvent event) {
        Main.showEvent(event);
    }
}