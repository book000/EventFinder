package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.FluidLevelChangeEvent;

public class OnFluidLevelChangeEvent implements Listener {
    public OnFluidLevelChangeEvent() {
    }

    @EventHandler
    public void onFluidLevelChangeEvent(FluidLevelChangeEvent event) {
        Main.showEvent(event);
    }
}