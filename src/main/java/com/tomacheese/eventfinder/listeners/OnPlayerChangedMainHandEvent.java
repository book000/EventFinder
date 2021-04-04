package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedMainHandEvent;

public class OnPlayerChangedMainHandEvent implements Listener {
    public OnPlayerChangedMainHandEvent() {
    }

    @EventHandler
    public void onPlayerChangedMainHandEvent(PlayerChangedMainHandEvent event) {
        Main.showEvent(event);
    }
}