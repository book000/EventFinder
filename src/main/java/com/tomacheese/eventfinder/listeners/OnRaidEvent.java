package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidEvent;

public class OnRaidEvent implements Listener {
    public OnRaidEvent() {
    }

    @EventHandler
    public void onRaidEvent(RaidEvent event) {
        Main.showEvent(event);
    }
}