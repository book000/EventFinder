package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class OnWeatherChangeEvent implements Listener {
    public OnWeatherChangeEvent() {
    }

    @EventHandler
    public void onWeatherChangeEvent(WeatherChangeEvent event) {
        Main.showEvent(event);
    }
}