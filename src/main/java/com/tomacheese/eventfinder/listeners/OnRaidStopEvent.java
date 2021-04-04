package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidStopEvent;

public class OnRaidStopEvent implements Listener {
    public OnRaidStopEvent() {
    }

    @EventHandler
    public void onRaidStopEvent(RaidStopEvent event) {
        Main.showEvent(event);
    }
}