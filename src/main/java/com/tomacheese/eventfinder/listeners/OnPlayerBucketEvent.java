package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEvent;

public class OnPlayerBucketEvent implements Listener {
    public OnPlayerBucketEvent() {
    }

    @EventHandler
    public void onPlayerBucketEvent(PlayerBucketEvent event) {
        Main.showEvent(event);
    }
}