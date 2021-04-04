package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.profile.PreFillProfileEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPreFillProfileEvent implements Listener {
    public OnPreFillProfileEvent() {
    }

    @EventHandler
    public void onPreFillProfileEvent(PreFillProfileEvent event) {
        Main.showEvent(event);
    }
}