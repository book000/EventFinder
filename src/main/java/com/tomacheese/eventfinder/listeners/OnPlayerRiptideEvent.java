package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRiptideEvent;

public class OnPlayerRiptideEvent implements Listener {
    public OnPlayerRiptideEvent() {
    }

    @EventHandler
    public void onPlayerRiptideEvent(PlayerRiptideEvent event) {
        Main.showEvent(event);
    }
}