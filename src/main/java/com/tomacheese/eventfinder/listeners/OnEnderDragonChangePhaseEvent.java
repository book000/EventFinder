package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EnderDragonChangePhaseEvent;

public class OnEnderDragonChangePhaseEvent implements Listener {
    public OnEnderDragonChangePhaseEvent() {
    }

    @EventHandler
    public void onEnderDragonChangePhaseEvent(EnderDragonChangePhaseEvent event) {
        Main.showEvent(event);
    }
}