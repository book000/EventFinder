package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnAsyncTabCompleteEvent implements Listener {
    public OnAsyncTabCompleteEvent() {
    }

    @EventHandler
    public void onAsyncTabCompleteEvent(AsyncTabCompleteEvent event) {
        Main.showEvent(event);
    }
}