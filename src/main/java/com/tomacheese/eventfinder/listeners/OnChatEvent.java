package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.ChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnChatEvent implements Listener {
    public OnChatEvent() {
    }

    @EventHandler
    public void onChatEvent(ChatEvent event) {
        Main.showEvent(event);
    }
}