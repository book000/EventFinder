package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEnderDragonFireballHitEvent implements Listener {
    public OnEnderDragonFireballHitEvent() {
    }

    @EventHandler
    public void onEnderDragonFireballHitEvent(EnderDragonFireballHitEvent event) {
        Main.showEvent(event);
    }
}