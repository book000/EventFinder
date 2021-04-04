package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWorldBorderCenterChangeEvent implements Listener {
    public OnWorldBorderCenterChangeEvent() {
    }

    @EventHandler
    public void onWorldBorderCenterChangeEvent(WorldBorderCenterChangeEvent event) {
        Main.showEvent(event);
    }
}