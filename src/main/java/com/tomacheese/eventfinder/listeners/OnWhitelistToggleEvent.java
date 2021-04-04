package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.server.WhitelistToggleEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWhitelistToggleEvent implements Listener {
    public OnWhitelistToggleEvent() {
    }

    @EventHandler
    public void onWhitelistToggleEvent(WhitelistToggleEvent event) {
        Main.showEvent(event);
    }
}