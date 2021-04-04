package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.ThunderChangeEvent;

public class OnThunderChangeEvent implements Listener {
    public OnThunderChangeEvent() {
    }

    @EventHandler
    public void onThunderChangeEvent(ThunderChangeEvent event) {
        Main.showEvent(event);
    }
}