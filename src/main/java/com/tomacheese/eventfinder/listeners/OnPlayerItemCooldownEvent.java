package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerItemCooldownEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerItemCooldownEvent implements Listener {
    public OnPlayerItemCooldownEvent() {
    }

    @EventHandler
    public void onPlayerItemCooldownEvent(PlayerItemCooldownEvent event) {
        Main.showEvent(event);
    }
}