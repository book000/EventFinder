package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.SkeletonHorseTrapEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnSkeletonHorseTrapEvent implements Listener {
    public OnSkeletonHorseTrapEvent() {
    }

    @EventHandler
    public void onSkeletonHorseTrapEvent(SkeletonHorseTrapEvent event) {
        Main.showEvent(event);
    }
}