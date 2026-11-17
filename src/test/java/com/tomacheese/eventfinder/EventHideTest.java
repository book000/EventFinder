package com.tomacheese.eventfinder;

import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/** Tests hide-pattern short-circuiting and visible-event text filtering. */
public class EventHideTest {
    private List<String> originalPatterns;
    private Field patternsField;
    private Field filterField;
    private Object originalFilter;

    /** Isolates the global hide patterns and text filter. */
    @Before
    public void saveState() throws Exception {
        originalPatterns = Main.getHidePatterns();
        patternsField = Main.class.getDeclaredField("hidePattern");
        patternsField.setAccessible(true);
        patternsField.set(null, Collections.emptyList());
        filterField = Main.class.getDeclaredField("filter");
        filterField.setAccessible(true);
        originalFilter = filterField.get(null);
        filterField.set(null, null);
    }

    /** Restores the global hide patterns and text filter. */
    @After
    public void restoreState() throws Exception {
        patternsField.set(null, originalPatterns);
        filterField.set(null, originalFilter);
    }

    /** Exact name matches skip detail access and conversion in either detail mode. */
    @Test
    public void exactHideSkipsDetailGettersAndConversion() throws Exception {
        assertHiddenWithoutDetails("countingevent");
    }

    /** Shorter prefixes skip detail access and conversion in either detail mode. */
    @Test
    public void prefixHideSkipsDetailGettersAndConversion() throws Exception {
        assertHiddenWithoutDetails("counting");
    }

    /** A pattern contained later in the name does not hide a visible event. */
    @Test
    public void nonPrefixPatternKeepsVisibleDetails() throws Exception {
        patternsField.set(null, Collections.singletonList("event"));
        CountingEvent event = new CountingEvent();

        Component message = Main.formatEvent(event, true);

        assertNotNull(message);
        assertTrue(Main.plainText(message).contains("Detail:detail-only-token"));
        assertEquals(1, event.detailCalls);
        assertEquals(1, event.conversionCalls);
    }

    /** Visible events still omit detail getters in the default mode. */
    @Test
    public void defaultModeKeepsVisibleEventWithoutDetails() {
        CountingEvent event = new CountingEvent();

        Component message = Main.formatEvent(event, false);

        assertNotNull(message);
        assertTrue(Main.plainText(message).contains("CountingEvent"));
        assertFalse(Main.plainText(message).contains("detail-only-token"));
        assertEquals(0, event.detailCalls);
        assertEquals(0, event.conversionCalls);
    }

    /** Text filtering runs after details have been converted to message content. */
    @Test
    public void textFilterCanMatchOnlyDetailContent() throws Exception {
        filterField.set(null, "detail-only-token");
        CountingEvent matching = new CountingEvent();

        assertNotNull(Main.formatEvent(matching, true));
        assertEquals(1, matching.detailCalls);
        assertEquals(1, matching.conversionCalls);

        filterField.set(null, "missing-token");
        assertNull(Main.formatEvent(new CountingEvent(), true));
    }

    private void assertHiddenWithoutDetails(String pattern) throws Exception {
        patternsField.set(null, Collections.singletonList(pattern));
        for (boolean fullDetails : new boolean[]{false, true}) {
            CountingEvent event = new CountingEvent();
            assertNull(Main.formatEvent(event, fullDetails));
            assertEquals(0, event.detailCalls);
            assertEquals(0, event.conversionCalls);
        }
    }

    /** Provides observable getter and conversion work for event formatting tests. */
    public static final class CountingEvent extends Event {
        private int detailCalls;
        private int conversionCalls;

        /** Returns a value whose conversion can be counted separately from access. */
        public Object getDetail() {
            detailCalls++;
            return new Object() {
                @Override
                public String toString() {
                    conversionCalls++;
                    return "detail-only-token";
                }
            };
        }

        /** Returns no handlers because the event is formatted without registration. */
        @Override
        public HandlerList getHandlers() {
            return null;
        }
    }
}
