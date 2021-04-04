package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.profile.LookupProfileEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnLookupProfileEvent implements Listener {
    public OnLookupProfileEvent() {
    }

    @EventHandler
    public void onLookupProfileEvent(LookupProfileEvent event) {
        Main.showEvent(event);
    }
}