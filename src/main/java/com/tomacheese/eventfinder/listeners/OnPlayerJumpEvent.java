package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerJumpEvent implements Listener {
    public OnPlayerJumpEvent() {
    }

    @EventHandler
    public void onPlayerJumpEvent(PlayerJumpEvent event) {
        Main.showEvent(event);
    }
}