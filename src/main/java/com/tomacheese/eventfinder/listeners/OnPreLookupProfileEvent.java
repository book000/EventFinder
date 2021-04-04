package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.profile.PreLookupProfileEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPreLookupProfileEvent implements Listener {
    public OnPreLookupProfileEvent() {
    }

    @EventHandler
    public void onPreLookupProfileEvent(PreLookupProfileEvent event) {
        Main.showEvent(event);
    }
}