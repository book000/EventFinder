package com.tomacheese.eventfinder;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class EventPrivacyTest {
    @Test
    public void defaultOutputOmitsLoginAddressesAndCommandText() throws Exception {
        InetAddress address = InetAddress.getByName("203.0.113.10");
        AsyncPlayerPreLoginEvent login = new AsyncPlayerPreLoginEvent("test", address, address, UUID.randomUUID(), null);
        PlayerCommandPreprocessEvent command = new PlayerCommandPreprocessEvent(null, "/msg user private-secret", Collections.emptySet());
        String loginText = Main.plainText(Main.formatEvent(login, false));
        String commandText = Main.plainText(Main.formatEvent(command, false));
        assertTrue(loginText.contains("AsyncPlayerPreLoginEvent"));
        assertFalse(loginText.contains("203.0.113.10"));
        assertFalse(loginText.contains("Address:"));
        assertFalse(loginText.contains("RawAddress:"));
        assertFalse(commandText.contains("private-secret"));
        assertFalse(commandText.contains("Message:"));
        assertTrue(Main.plainText(Main.formatEvent(login, true)).contains("203.0.113.10"));
        assertTrue(Main.plainText(Main.formatEvent(command, true)).contains("private-secret"));
    }

    @Test
    public void onlyPermittedPlayersReceiveEvents() throws Exception {
        AtomicInteger received = new AtomicInteger();
        Player denied = player(false, received);
        Player allowed = player(true, received);
        Main.sendEvent(Component.text("event"), Arrays.asList(denied, allowed));
        assertEquals(1, received.get());
    }

    private Player player(boolean allowed, AtomicInteger received) {
        return (Player) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{Player.class}, (proxy, method, args) -> {
            if (method.getName().equals("hasPermission")) return allowed && "eventfinder.view".equals(args[0]);
            if (method.getName().equals("sendMessage")) received.incrementAndGet();
            return null;
        });
    }
}
