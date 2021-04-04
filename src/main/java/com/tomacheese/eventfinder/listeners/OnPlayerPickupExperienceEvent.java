package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerPickupExperienceEvent implements Listener {
    public OnPlayerPickupExperienceEvent() {
    }

    @EventHandler
    public void onPlayerPickupExperienceEvent(PlayerPickupExperienceEvent event) {
        Main.showEvent(event);
    }
}