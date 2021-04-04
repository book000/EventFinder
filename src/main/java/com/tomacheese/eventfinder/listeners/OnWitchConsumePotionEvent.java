package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.WitchConsumePotionEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWitchConsumePotionEvent implements Listener {
    public OnWitchConsumePotionEvent() {
    }

    @EventHandler
    public void onWitchConsumePotionEvent(WitchConsumePotionEvent event) {
        Main.showEvent(event);
    }
}