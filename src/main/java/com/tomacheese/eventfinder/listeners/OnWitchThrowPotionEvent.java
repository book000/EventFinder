package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.WitchThrowPotionEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWitchThrowPotionEvent implements Listener {
    public OnWitchThrowPotionEvent() {
    }

    @EventHandler
    public void onWitchThrowPotionEvent(WitchThrowPotionEvent event) {
        Main.showEvent(event);
    }
}