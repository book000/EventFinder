package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

public class OnTabCompleteEvent implements Listener {
    public OnTabCompleteEvent() {
    }

    @EventHandler
    public void onTabCompleteEvent(TabCompleteEvent event) {
        Main.showEvent(event);
    }
}