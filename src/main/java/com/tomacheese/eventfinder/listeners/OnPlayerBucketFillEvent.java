package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class OnPlayerBucketFillEvent implements Listener {
    public OnPlayerBucketFillEvent() {
    }

    @EventHandler
    public void onPlayerBucketFillEvent(PlayerBucketFillEvent event) {
        Main.showEvent(event);
    }
}