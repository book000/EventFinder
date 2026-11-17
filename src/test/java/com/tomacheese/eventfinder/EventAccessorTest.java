package com.tomacheese.eventfinder;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventAccessorTest {
    @Test
    public void realDamageEventUsesZeroArgumentDamageAccessor() {
        EntityDamageEvent event = new EntityDamageEvent(null, EntityDamageEvent.DamageCause.FALL, 5.0);
        String text = Main.plainText(Main.formatEvent(event, true));
        assertTrue(text, text.matches("(?s).*\\bDamage:5\\.0(?:\\s|$).*"));
        assertFalse(text, text.contains("OriginalDamage:"));
    }

    @Test
    public void duplicateKeysSelectOneAccessorEvenWhenItReturnsNullOrThrows() {
        CollisionEvent event = new CollisionEvent();
        String text = Main.plainText(Main.formatEvent(event, true));
        assertTrue(text, text.contains("Value:NULL"));
        assertTrue(text, text.contains("Failure:?"));
        assertFalse(text, text.contains("StaticValue:"));
        assertFalse(text, text.contains("ParameterOnly:"));
        assertEquals(0, event.alternateCalls);
        assertEquals(0, CollisionEvent.staticCalls);
    }

    public static class CollisionEvent extends Event {
        static int staticCalls;
        int alternateCalls;

        public String getValue() { return null; }
        public String isValue() { alternateCalls++; return "alternate"; }
        public String getFailure() { throw new IllegalStateException(); }
        public String isFailure() { alternateCalls++; return "alternate"; }
        public static String getStaticValue() { staticCalls++; return "static"; }
        public String getParameterOnly(String ignored) { return ignored; }
        @Override public HandlerList getHandlers() { return null; }
    }
}
