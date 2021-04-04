package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class OnExpBottleEvent implements Listener {
    public OnExpBottleEvent() {
    }

    @EventHandler
    public void onExpBottleEvent(ExpBottleEvent event) {
        Main.showEvent(event);
    }
}