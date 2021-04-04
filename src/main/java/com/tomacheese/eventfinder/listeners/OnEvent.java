package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEvent implements Listener {
    public OnEvent() {
    }

    @EventHandler
    public void onEvent(Event event) {
        Main.showEvent(event);
    }
}