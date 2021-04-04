package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;

public class OnPlayerPickupArrowEvent implements Listener {
    public OnPlayerPickupArrowEvent() {
    }

    @EventHandler
    public void onPlayerPickupArrowEvent(PlayerPickupArrowEvent event) {
        Main.showEvent(event);
    }
}