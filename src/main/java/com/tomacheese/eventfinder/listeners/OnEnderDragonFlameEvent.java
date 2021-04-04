package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EnderDragonFlameEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEnderDragonFlameEvent implements Listener {
    public OnEnderDragonFlameEvent() {
    }

    @EventHandler
    public void onEnderDragonFlameEvent(EnderDragonFlameEvent event) {
        Main.showEvent(event);
    }
}