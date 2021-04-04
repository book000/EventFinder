package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.server.ServerTickEndEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnServerTickEndEvent implements Listener {
    public OnServerTickEndEvent() {
    }

    @EventHandler
    public void onServerTickEndEvent(ServerTickEndEvent event) {
        Main.showEvent(event);
    }
}