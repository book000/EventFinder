package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.block.TargetHitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnTargetHitEvent implements Listener {
    public OnTargetHitEvent() {
    }

    @EventHandler
    public void onTargetHitEvent(TargetHitEvent event) {
        Main.showEvent(event);
    }
}