package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServiceRegisterEvent;

public class OnServiceRegisterEvent implements Listener {
    public OnServiceRegisterEvent() {
    }

    @EventHandler
    public void onServiceRegisterEvent(ServiceRegisterEvent event) {
        Main.showEvent(event);
    }
}