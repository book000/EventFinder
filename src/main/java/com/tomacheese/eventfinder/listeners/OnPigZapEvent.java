package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PigZapEvent;

public class OnPigZapEvent implements Listener {
    public OnPigZapEvent() {
    }

    @EventHandler
    public void onPigZapEvent(PigZapEvent event) {
        Main.showEvent(event);
    }
}