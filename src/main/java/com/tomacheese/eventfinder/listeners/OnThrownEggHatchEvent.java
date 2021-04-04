package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.ThrownEggHatchEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnThrownEggHatchEvent implements Listener {
    public OnThrownEggHatchEvent() {
    }

    @EventHandler
    public void onThrownEggHatchEvent(ThrownEggHatchEvent event) {
        Main.showEvent(event);
    }
}