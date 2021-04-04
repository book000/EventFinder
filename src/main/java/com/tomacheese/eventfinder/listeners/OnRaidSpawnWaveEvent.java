package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidSpawnWaveEvent;

public class OnRaidSpawnWaveEvent implements Listener {
    public OnRaidSpawnWaveEvent() {
    }

    @EventHandler
    public void onRaidSpawnWaveEvent(RaidSpawnWaveEvent event) {
        Main.showEvent(event);
    }
}