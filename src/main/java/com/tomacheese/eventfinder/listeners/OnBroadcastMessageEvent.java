package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.BroadcastMessageEvent;

public class OnBroadcastMessageEvent implements Listener {
    public OnBroadcastMessageEvent() {
    }

    @EventHandler
    public void onBroadcastMessageEvent(BroadcastMessageEvent event) {
        Main.showEvent(event);
    }
}