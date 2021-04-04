package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEvent;

public class OnPluginEvent implements Listener {
    public OnPluginEvent() {
    }

    @EventHandler
    public void onPluginEvent(PluginEvent event) {
        Main.showEvent(event);
    }
}