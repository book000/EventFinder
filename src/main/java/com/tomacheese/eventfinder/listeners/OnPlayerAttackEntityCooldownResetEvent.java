package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerAttackEntityCooldownResetEvent implements Listener {
    public OnPlayerAttackEntityCooldownResetEvent() {
    }

    @EventHandler
    public void onPlayerAttackEntityCooldownResetEvent(PlayerAttackEntityCooldownResetEvent event) {
        Main.showEvent(event);
    }
}