package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPaperServerListPingEvent implements Listener {
    public OnPaperServerListPingEvent() {
    }

    @EventHandler
    public void onPaperServerListPingEvent(PaperServerListPingEvent event) {
        Main.showEvent(event);
    }
}