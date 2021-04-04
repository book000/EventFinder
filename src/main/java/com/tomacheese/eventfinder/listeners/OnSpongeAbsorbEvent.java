package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SpongeAbsorbEvent;

public class OnSpongeAbsorbEvent implements Listener {
    public OnSpongeAbsorbEvent() {
    }

    @EventHandler
    public void onSpongeAbsorbEvent(SpongeAbsorbEvent event) {
        Main.showEvent(event);
    }
}