package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnSlimeTargetLivingEntityEvent implements Listener {
    public OnSlimeTargetLivingEntityEvent() {
    }

    @EventHandler
    public void onSlimeTargetLivingEntityEvent(SlimeTargetLivingEntityEvent event) {
        Main.showEvent(event);
    }
}