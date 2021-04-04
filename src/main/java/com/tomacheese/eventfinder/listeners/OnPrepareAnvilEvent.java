package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

public class OnPrepareAnvilEvent implements Listener {
    public OnPrepareAnvilEvent() {
    }

    @EventHandler
    public void onPrepareAnvilEvent(PrepareAnvilEvent event) {
        Main.showEvent(event);
    }
}