package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.command.UnknownCommandEvent;

public class OnUnknownCommandEvent implements Listener {
    public OnUnknownCommandEvent() {
    }

    @EventHandler
    public void onUnknownCommandEvent(UnknownCommandEvent event) {
        Main.showEvent(event);
    }
}