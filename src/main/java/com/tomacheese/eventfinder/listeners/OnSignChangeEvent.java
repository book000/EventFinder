package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class OnSignChangeEvent implements Listener {
    public OnSignChangeEvent() {
    }

    @EventHandler
    public void onSignChangeEvent(SignChangeEvent event) {
        Main.showEvent(event);
    }
}