package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.server.ServerResourcesReloadedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnServerResourcesReloadedEvent implements Listener {
    public OnServerResourcesReloadedEvent() {
    }

    @EventHandler
    public void onServerResourcesReloadedEvent(ServerResourcesReloadedEvent event) {
        Main.showEvent(event);
    }
}