package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EnderDragonShootFireballEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEnderDragonShootFireballEvent implements Listener {
    public OnEnderDragonShootFireballEvent() {
    }

    @EventHandler
    public void onEnderDragonShootFireballEvent(EnderDragonShootFireballEvent event) {
        Main.showEvent(event);
    }
}