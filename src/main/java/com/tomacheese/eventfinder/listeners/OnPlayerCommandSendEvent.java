package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class OnPlayerCommandSendEvent implements Listener {
    public OnPlayerCommandSendEvent() {
    }

    @EventHandler
    public void onPlayerCommandSendEvent(PlayerCommandSendEvent event) {
        Main.showEvent(event);
    }
}