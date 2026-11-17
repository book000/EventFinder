package com.tomacheese.eventfinder;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HidePatternPersistenceTest {
    @Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private Main main;
    private Commands commands;
    private File configFile;
    private CommandSender sender;
    private List<String> defaults;

    @Before
    public void setUp() throws Exception {
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        Field instance = unsafeClass.getDeclaredField("theUnsafe");
        instance.setAccessible(true);
        Object unsafe = instance.get(null);
        main = (Main) unsafeClass.getMethod("allocateInstance", Class.class).invoke(unsafe, Main.class);
        configFile = temporaryFolder.newFile("config.yml");
        Files.copy(getClass().getResourceAsStream("/config.yml"), configFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        setPluginField("configFile", configFile);
        setPluginField("dataFolder", temporaryFolder.getRoot());
        setPluginField("classLoader", getClass().getClassLoader());
        setPluginField("logger", java.util.logging.Logger.getLogger("HidePatternPersistenceTest"));
        main.reloadConfig();
        main.conf = main.getConfig();
        main.loadHidePattern();
        defaults = new ArrayList<>(Main.hidePattern);
        commands = new Commands(main);
        sender = (CommandSender) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{CommandSender.class},
            (proxy, method, args) -> null);
    }

    @After
    public void tearDown() {
        Main.hidePattern.clear();
    }

    private void setPluginField(String name, Object value) throws Exception {
        Field field = JavaPlugin.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(main, value);
    }

    private void roundTrip(String... command) {
        assertTrue(commands.onCommand(sender, null, "event", command));
        List<String> expected = new ArrayList<>(Main.hidePattern);
        assertNotSame(Main.hidePattern, main.conf.getList(Main.CONF_HIDE_PATTERN));
        commands.load(sender, new String[]{"load"});
        assertEquals(expected, Main.hidePattern);
        commands.save(sender, new String[]{"save"});
        assertEquals(expected, YamlConfiguration.loadConfiguration(configFile).getStringList(Main.CONF_HIDE_PATTERN));
    }

    @Test
    public void mutationsAndSaveSurviveLoadAndSave() {
        assertTrue(defaults.contains("playermoveevent"));
        assertTrue(defaults.contains("blockphysicsevent"));
        roundTrip("hide", "ExampleEvent");
        roundTrip("hide", "AnotherEvent", "ThirdEvent");
        roundTrip("show", "ExampleEvent");
        roundTrip("show", "AnotherEvent", "ThirdEvent");
        roundTrip("toggle", "ExampleEvent");
        roundTrip("toggle", "ExampleEvent");
        roundTrip("save");
        assertEquals(defaults, Main.hidePattern);
    }

    @Test
    public void aliasedListIsSnapshottedBeforeClearing() {
        main.conf.set(Main.CONF_HIDE_PATTERN, Main.hidePattern);
        main.loadHidePattern();
        assertEquals(defaults, Main.hidePattern);
        main.conf.set(Main.CONF_HIDE_PATTERN, Arrays.asList("MixedCase", "mixedcase", "Other"));
        main.loadHidePattern();
        assertEquals(Arrays.asList("mixedcase", "other"), Main.hidePattern);
        main.conf = new YamlConfiguration();
        main.loadHidePattern();
        assertTrue(Main.hidePattern.isEmpty());
    }

    @Test
    public void loadReadsDiskEditsAndSavePreservesOtherEdits() throws Exception {
        YamlConfiguration edited = YamlConfiguration.loadConfiguration(configFile);
        edited.set(Main.CONF_HIDE_PATTERN, Arrays.asList("EditedEvent"));
        edited.set("debug.fullEventDetails", true);
        edited.save(configFile);
        commands.load(sender, new String[]{"load"});
        assertSame(main.getConfig(), main.conf);
        assertEquals(Arrays.asList("editedevent"), Main.hidePattern);
        commands.save(sender, new String[]{"save"});
        YamlConfiguration saved = YamlConfiguration.loadConfiguration(configFile);
        assertEquals(Arrays.asList("editedevent"), saved.getStringList(Main.CONF_HIDE_PATTERN));
        assertTrue(saved.getBoolean("debug.fullEventDetails"));
    }

    @Test
    public void invalidDiskEditLeavesActiveSettingsAndFileUntouched() throws Exception {
        byte[] invalid = "hidePattern: [broken\n".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        Files.write(configFile.toPath(), invalid);
        commands.load(sender, new String[]{"load"});
        assertEquals(defaults, Main.hidePattern);
        assertArrayEquals(invalid, Files.readAllBytes(configFile.toPath()));
        assertEquals(defaults, main.conf.getStringList(Main.CONF_HIDE_PATTERN));
    }
}
