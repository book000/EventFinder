package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

public class OnPotionSplashEvent implements Listener {
    public OnPotionSplashEvent() {
    }

    @EventHandler
    public void onPotionSplashEvent(PotionSplashEvent event) {
        Main.showEvent(event);
    }
}