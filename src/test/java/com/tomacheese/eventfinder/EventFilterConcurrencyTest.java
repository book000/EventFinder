package com.tomacheese.eventfinder;

import net.kyori.adventure.text.Component;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Regression coverage for snapshots shared by asynchronous events and commands.
 */
public class EventFilterConcurrencyTest {
    private Main main;

    /**
     * Creates a configuration-only plugin fixture without starting Paper.
     *
     * @throws Exception if the fixture cannot be allocated
     */
    @Before
    public void initializeState() throws Exception {
        // The plugin constructor requires Paper's class loader; only configuration is needed here.
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        Field field = unsafeClass.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        main = (Main) unsafeClass.getMethod("allocateInstance", Class.class).invoke(field.get(null), Main.class);
        main.conf = new YamlConfiguration();
        resetState();
    }

    /**
     * Restores shared hide and filter state after each test.
     */
    @After
    public void resetState() {
        if (main != null) {
            main.setFilter(null);
            main.conf.set(Main.CONF_HIDE_PATTERN, null);
            main.loadHidePattern();
        }
    }

    /**
     * Checks retained snapshots cannot be changed by callers, commands, or configuration aliases.
     */
    @Test
    public void snapshotsRemainImmutableAndIndependentOfLaterChanges() {
        List<String> configured = new ArrayList<>(Arrays.asList("PLAYER", "player", "Block"));
        main.conf.set(Main.CONF_HIDE_PATTERN, configured);
        main.loadHidePattern();
        List<String> snapshot = Main.getHidePatterns();
        assertEquals(Arrays.asList("player", "block"), snapshot);
        try {
            snapshot.add("changed");
            fail("Hide snapshots must be immutable");
        } catch (UnsupportedOperationException expected) {
            assertEquals(Arrays.asList("player", "block"), snapshot);
        }
        configured.clear();
        assertFalse(main.addHidePattern("PLAYER"));
        assertTrue(main.addHidePattern("Inventory"));
        assertTrue(main.removeHidePattern("BLOCK"));
        assertFalse(main.removeHidePattern("missing"));
        assertEquals(Arrays.asList("player", "inventory"), Main.getHidePatterns());
        assertEquals(Arrays.asList("player", "block"), snapshot);
        main.conf.set(Main.CONF_HIDE_PATTERN, null);
        main.loadHidePattern();
        assertTrue(Main.getHidePatterns().isEmpty());
        assertEquals(Arrays.asList("player", "block"), snapshot);
    }

    /**
     * Checks event-data reads cannot change the hide or filter decision already captured for that event.
     */
    @Test
    public void eachEventCapturesHideAndFilterBeforeReadingEventData() {
        main.addHidePattern("snapshot");
        assertNull(Main.formatEvent(new SnapshotEvent(() -> main.removeHidePattern("snapshot")), false));
        assertNotNull(Main.formatEvent(new SnapshotEvent(() -> {}), false));

        main.setFilter("unmatched");
        assertNull(Main.formatEvent(new SnapshotEvent(() -> main.setFilter(null)), false));
        Component visible = Main.formatEvent(new SnapshotEvent(() -> main.setFilter("unmatched")), false);
        assertNotNull(visible);
        assertTrue(Main.plainText(visible).contains("SnapshotEvent"));
        assertNull(Main.formatEvent(new SnapshotEvent(() -> {}), false));
        main.setFilter("SnapshotEvent");
        assertNotNull(Main.formatEvent(new SnapshotEvent(() -> {}), false));
    }

    /**
     * Checks readers retain the previous complete configuration while a replacement is being converted.
     *
     * @throws Exception if a concurrent worker fails or does not finish
     */
    @Test(timeout = 10000)
    public void reloadPublishesOnlyTheCompleteReplacement() throws Exception {
        main.addHidePattern("old");
        List<String> previous = Main.getHidePatterns();
        CountDownLatch converting = new CountDownLatch(1);
        CountDownLatch finishConversion = new CountDownLatch(1);
        Object delayedPattern = new Object() {
            @Override
            public String toString() {
                converting.countDown();
                try {
                    if (!finishConversion.await(5, TimeUnit.SECONDS)) {
                        throw new AssertionError("Timed out waiting to finish configuration conversion");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
                return "NEW";
            }
        };
        main.conf.set(Main.CONF_HIDE_PATTERN, Arrays.asList(delayedPattern, "Second"));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<?> reload = executor.submit(main::loadHidePattern);
            assertTrue(converting.await(5, TimeUnit.SECONDS));
            assertEquals(Collections.singletonList("old"), Main.getHidePatterns());
            finishConversion.countDown();
            reload.get(5, TimeUnit.SECONDS);
            assertEquals(Arrays.asList("new", "second"), Main.getHidePatterns());
            assertEquals(Collections.singletonList("old"), previous);
        } finally {
            finishConversion.countDown();
            executor.shutdownNow();
            assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
        }
    }

    /**
     * Exercises the async formatting path while another thread loads and modifies hide/filter state.
     *
     * @throws Exception if a concurrent worker fails or does not finish
     */
    @Test(timeout = 20000)
    public void asyncEventFormattingCanRunAlongsideHideAndFilterCommands() throws Exception {
        Event event = new AsyncPlayerPreLoginEvent("test", InetAddress.getLoopbackAddress(),
            InetAddress.getLoopbackAddress(), UUID.randomUUID(), null);
        assertTrue(event.isAsynchronous());
        List<String> configured = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            configured.add("unmatched" + i);
        }
        main.conf.set(Main.CONF_HIDE_PATTERN, configured);
        main.loadHidePattern();
        CountDownLatch start = new CountDownLatch(1);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            Future<?> writer = executor.submit(() -> {
                await(start);
                for (int i = 0; i < 1000; i++) {
                    main.loadHidePattern();
                    assertTrue(main.addHidePattern("AsyncPlayer"));
                    assertTrue(main.removeHidePattern("ASYNCPLAYER"));
                    main.setFilter("unmatched");
                    main.setFilter(null);
                }
            });
            Future<?> reader = executor.submit(() -> {
                await(start);
                for (int i = 0; i < 2000; i++) {
                    Component message = Main.formatEvent(event, false);
                    if (message != null) {
                        assertTrue(Main.plainText(message).contains("AsyncPlayerPreLoginEvent"));
                    }
                    List<String> snapshot = Main.getHidePatterns();
                    assertTrue(snapshot.size() == 128 || snapshot.size() == 129);
                    assertEquals("unmatched0", snapshot.get(0));
                    assertEquals("unmatched127", snapshot.get(127));
                }
            });
            start.countDown();
            writer.get(15, TimeUnit.SECONDS);
            reader.get(15, TimeUnit.SECONDS);
        } finally {
            executor.shutdownNow();
            assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
        }
        assertEquals(configured, Main.getHidePatterns());
        assertNotNull(Main.formatEvent(event, false));
    }

    private static void await(CountDownLatch latch) {
        try {
            if (!latch.await(5, TimeUnit.SECONDS)) {
                throw new AssertionError("Timed out waiting for concurrent workers");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }

    private static final class SnapshotEvent extends Event {
        private static final HandlerList HANDLERS = new HandlerList();
        private final Runnable onRead;

        private SnapshotEvent(Runnable onRead) {
            super(true);
            this.onRead = onRead;
        }

        @Override
        public String getEventName() {
            onRead.run();
            return "SnapshotEvent";
        }

        @Override
        public HandlerList getHandlers() {
            return HANDLERS;
        }
    }
}
