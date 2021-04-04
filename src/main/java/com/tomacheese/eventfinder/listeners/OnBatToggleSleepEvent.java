package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.BatToggleSleepEvent;

public class OnBatToggleSleepEvent implements Listener {
    public OnBatToggleSleepEvent() {
    }

    @EventHandler
    public void onBatToggleSleepEvent(BatToggleSleepEvent event) {
        Main.showEvent(event);
    }
}