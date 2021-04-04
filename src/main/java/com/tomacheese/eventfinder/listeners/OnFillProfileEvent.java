package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.profile.FillProfileEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnFillProfileEvent implements Listener {
    public OnFillProfileEvent() {
    }

    @EventHandler
    public void onFillProfileEvent(FillProfileEvent event) {
        Main.showEvent(event);
    }
}