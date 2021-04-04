package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.IllegalPacketEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnIllegalPacketEvent implements Listener {
    public OnIllegalPacketEvent() {
    }

    @EventHandler
    public void onIllegalPacketEvent(IllegalPacketEvent event) {
        Main.showEvent(event);
    }
}