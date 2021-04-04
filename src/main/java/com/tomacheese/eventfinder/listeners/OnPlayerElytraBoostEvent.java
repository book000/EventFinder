package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerElytraBoostEvent implements Listener {
    public OnPlayerElytraBoostEvent() {
    }

    @EventHandler
    public void onPlayerElytraBoostEvent(PlayerElytraBoostEvent event) {
        Main.showEvent(event);
    }
}