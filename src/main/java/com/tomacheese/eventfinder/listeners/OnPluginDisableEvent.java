package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

public class OnPluginDisableEvent implements Listener {
    public OnPluginDisableEvent() {
    }

    @EventHandler
    public void onPluginDisableEvent(PluginDisableEvent event) {
        Main.showEvent(event);
    }
}