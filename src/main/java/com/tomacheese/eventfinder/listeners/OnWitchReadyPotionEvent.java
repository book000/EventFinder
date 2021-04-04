package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.WitchReadyPotionEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWitchReadyPotionEvent implements Listener {
    public OnWitchReadyPotionEvent() {
    }

    @EventHandler
    public void onWitchReadyPotionEvent(WitchReadyPotionEvent event) {
        Main.showEvent(event);
    }
}