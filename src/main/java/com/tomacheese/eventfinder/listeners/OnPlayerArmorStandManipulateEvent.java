package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class OnPlayerArmorStandManipulateEvent implements Listener {
    public OnPlayerArmorStandManipulateEvent() {
    }

    @EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
        Main.showEvent(event);
    }
}