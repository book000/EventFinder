package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.LingeringPotionSplashEvent;

public class OnLingeringPotionSplashEvent implements Listener {
    public OnLingeringPotionSplashEvent() {
    }

    @EventHandler
    public void onLingeringPotionSplashEvent(LingeringPotionSplashEvent event) {
        Main.showEvent(event);
    }
}