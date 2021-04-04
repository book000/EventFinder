package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidFinishEvent;

public class OnRaidFinishEvent implements Listener {
    public OnRaidFinishEvent() {
    }

    @EventHandler
    public void onRaidFinishEvent(RaidFinishEvent event) {
        Main.showEvent(event);
    }
}