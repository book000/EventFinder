package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class OnPlayerItemDamageEvent implements Listener {
    public OnPlayerItemDamageEvent() {
    }

    @EventHandler
    public void onPlayerItemDamageEvent(PlayerItemDamageEvent event) {
        Main.showEvent(event);
    }
}