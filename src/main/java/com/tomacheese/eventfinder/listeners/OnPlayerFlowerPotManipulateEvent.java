package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerFlowerPotManipulateEvent implements Listener {
    public OnPlayerFlowerPotManipulateEvent() {
    }

    @EventHandler
    public void onPlayerFlowerPotManipulateEvent(PlayerFlowerPotManipulateEvent event) {
        Main.showEvent(event);
    }
}