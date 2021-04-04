package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerLaunchProjectileEvent implements Listener {
    public OnPlayerLaunchProjectileEvent() {
    }

    @EventHandler
    public void onPlayerLaunchProjectileEvent(PlayerLaunchProjectileEvent event) {
        Main.showEvent(event);
    }
}