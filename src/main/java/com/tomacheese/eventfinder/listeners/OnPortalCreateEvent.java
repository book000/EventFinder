package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class OnPortalCreateEvent implements Listener {
    public OnPortalCreateEvent() {
    }

    @EventHandler
    public void onPortalCreateEvent(PortalCreateEvent event) {
        Main.showEvent(event);
    }
}