package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;

public class OnAreaEffectCloudApplyEvent implements Listener {
    public OnAreaEffectCloudApplyEvent() {
    }

    @EventHandler
    public void onAreaEffectCloudApplyEvent(AreaEffectCloudApplyEvent event) {
        Main.showEvent(event);
    }
}