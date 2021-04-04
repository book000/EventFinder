package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidTriggerEvent;

public class OnRaidTriggerEvent implements Listener {
    public OnRaidTriggerEvent() {
    }

    @EventHandler
    public void onRaidTriggerEvent(RaidTriggerEvent event) {
        Main.showEvent(event);
    }
}