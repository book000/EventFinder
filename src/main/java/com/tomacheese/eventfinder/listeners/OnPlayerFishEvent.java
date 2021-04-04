package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class OnPlayerFishEvent implements Listener {
    public OnPlayerFishEvent() {
    }

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent event) {
        Main.showEvent(event);
    }
}