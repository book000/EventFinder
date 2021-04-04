package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;

public class OnEntityBlockFormEvent implements Listener {
    public OnEntityBlockFormEvent() {
    }

    @EventHandler
    public void onEntityBlockFormEvent(EntityBlockFormEvent event) {
        Main.showEvent(event);
    }
}