package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.block.BellRingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnBellRingEvent implements Listener {
    public OnBellRingEvent() {
    }

    @EventHandler
    public void onBellRingEvent(BellRingEvent event) {
        Main.showEvent(event);
    }
}