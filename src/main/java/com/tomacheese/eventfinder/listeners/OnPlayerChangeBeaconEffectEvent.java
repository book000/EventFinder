package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerChangeBeaconEffectEvent implements Listener {
    public OnPlayerChangeBeaconEffectEvent() {
    }

    @EventHandler
    public void onPlayerChangeBeaconEffectEvent(PlayerChangeBeaconEffectEvent event) {
        Main.showEvent(event);
    }
}