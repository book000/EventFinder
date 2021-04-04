package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.profile.ProfileWhitelistVerifyEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnProfileWhitelistVerifyEvent implements Listener {
    public OnProfileWhitelistVerifyEvent() {
    }

    @EventHandler
    public void onProfileWhitelistVerifyEvent(ProfileWhitelistVerifyEvent event) {
        Main.showEvent(event);
    }
}