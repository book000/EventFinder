package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class OnBlockPhysicsEvent implements Listener {
    public OnBlockPhysicsEvent() {
    }

    @EventHandler
    public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
        Main.showEvent(event);
    }
}