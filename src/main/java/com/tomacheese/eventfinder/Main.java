package com.tomacheese.eventfinder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public final class Main extends JavaPlugin {
    public static final String CONF_HIDE_PATTERN = "hidePattern";
    private static final Map<String, NamedTextColor> pkgColor = new HashMap<>();
    public static final List<String> hidePattern = new ArrayList<>();
    public FileConfiguration conf;
    private static String filter = null;

    public void onEnable() {
        saveDefaultConfig();
        conf = getConfig();
        loadHidePattern();
        initPackageColor();

        Objects.requireNonNull(getCommand("event")).setExecutor(new Commands(this));

        registerEvents();
    }

    void registerEvents() {
        Reflections reflections = new Reflections("com.tomacheese.eventfinder.listeners");
        reflections.getSubTypesOf(Listener.class).forEach(clazz -> {
            try {
                getServer().getPluginManager().registerEvents(clazz.newInstance(), this);
            } catch (IllegalPluginAccessException | InstantiationException | IllegalAccessException e) {
                getLogger().warning("Register failed: " + clazz.getSimpleName());
            }
        });
    }

    public static void showEvent(Event event) {
        Class<?> handler = event.getClass();
        Map<String, Object> details = new HashMap<>();
        Method[] methods = event.getClass().getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (!methodName.startsWith("get") && !methodName.startsWith("is")) {
                continue;
            }
            if (methodName.contains("Handler")) {
                continue;
            }

            int cut = methodName.startsWith("get") ? 3 : methodName.startsWith("is") ? 2 : 0;

            try {
                details.put(method.getName().substring(cut), method.invoke(event));
            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                details.put(method.getName().substring(cut), "?");
            } catch (NullPointerException e) {
                details.put(method.getName().substring(cut), null);
            }
        }

        TextComponent.Builder builder = Component.text();

        builder.append(Component.text(handler.getSimpleName(), pkgColor.get(event.getClass().getPackage().getName()))
            .hoverEvent(HoverEvent.showText(Component.text(
                "Class: " + handler.getName() + "\n" +
                    "\n" +
                    "Methods:\n" +
                    Arrays.stream(methods)
                        .map(Method::toString)
                        .collect(Collectors.joining("\n")))))
            .clickEvent(ClickEvent.runCommand(String.format("/event toggle %s", handler.getSimpleName())))
        );

        if (!event.getEventName().equals(handler.getSimpleName())) {
            builder.append(Component.text("<" + event.getEventName() + ">", NamedTextColor.WHITE));
        }

        if (Arrays.stream(event.getClass().getDeclaredFields()).map(field -> field.getAnnotation(Deprecated.class)).anyMatch(Objects::nonNull)) {
            builder.append(Component.text("*", NamedTextColor.DARK_GRAY));
        }

        builder.append(Component.text(": ", NamedTextColor.WHITE));

        TextComponent.Builder methodsComponent = Component.text();
        details.entrySet().stream()
            .peek(s -> s.setValue(converter(s.getValue())))
            .map(s -> Component.text()
                .append(Component.text(s.getKey()))
                .append(Component.text(":"))
                .append((Component) s.getValue()))
            .forEach(c -> methodsComponent.append(c, Component.space()));
        builder.append(methodsComponent.colorIfAbsent(NamedTextColor.GRAY).build());

        String eventName = event.getEventName().toLowerCase();
        boolean isHide = hidePattern.stream().anyMatch(eventName::startsWith);
        if (isHide) {
            return;
        }

        if (event instanceof Cancellable && ((Cancellable) event).isCancelled()) {
            builder.decorate(TextDecoration.STRIKETHROUGH);
        }
        if (filter != null && !PlainComponentSerializer.plain().serialize(builder.build()).contains(filter)) {
            return;
        }
        Bukkit.getServer().sendMessage(builder.build());
    }

    static Component converter(Object obj) {
        if (obj instanceof Player) {
            Player player = (Player) obj;
            return Component.text(player.getName())
                .hoverEvent(HoverEvent.showText(Component.text(
                    obj.getClass().getName() + "\n" +
                        "\n" +
                        "getName:" + player.getName() + "\n" +
                        "getUniqueId: " + player.getUniqueId()
                )));
        }

        if (obj instanceof Location) {
            Location loc = (Location) obj;
            return Component.text(String.format("%s %d,%d,%d", loc.getWorld().getName(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()))
                .hoverEvent(HoverEvent.showText(Component.text(
                    obj.getClass().getName() + "\n" +
                        "\n" +
                        "getWorld.getName:" + loc.getWorld().getName() + "\n" +
                        "getX: " + loc.getX() + "\n" +
                        "getY: " + loc.getY() + "\n" +
                        "getZ: " + loc.getZ()
                )));
        }

        if (obj instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) obj;
            return Component.text(obj.getClass().getSimpleName())
                .append(Component.text("{"))
                .append(Component.text(livingEntity.getType().name()))
                .append(Component.text(", "))
                .append(converter(livingEntity.getLocation()))
                .append(Component.text("}"))
                .hoverEvent(HoverEvent.showText(Component.text(
                    obj.getClass().getName() + "\n" +
                        "\n" +
                        "getType.name:" + livingEntity.getType().name() + "\n" +
                        "getName: " + livingEntity.getName() + "\n" +
                        "getLocation.getWorld.getName: " + livingEntity.getLocation().getWorld().getName() + "\n" +
                        "getLocation.getX: " + livingEntity.getLocation().getX() + "\n" +
                        "getLocation.getY: " + livingEntity.getLocation().getY() + "\n" +
                        "getLocation.getZ: " + livingEntity.getLocation().getZ()
                )));
        }

        if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            return Component.text(obj.getClass().getSimpleName())
                .append(Component.text("{"))
                .append(Component.text(entity.getType().name()))
                .append(Component.text(", "))
                .append(converter(entity.getLocation()))
                .append(Component.text("}"))
                .hoverEvent(HoverEvent.showText(Component.text(
                    obj.getClass().getName() + "\n" +
                        "\n" +
                        "getType.name:" + entity.getType().name() + "\n" +
                        "getName: " + entity.getName() + "\n" +
                        "getLocation.getWorld.getName: " + entity.getLocation().getWorld().getName() + "\n" +
                        "getLocation.getX: " + entity.getLocation().getX() + "\n" +
                        "getLocation.getY: " + entity.getLocation().getY() + "\n" +
                        "getLocation.getZ: " + entity.getLocation().getZ()
                )));
        }

        if (obj instanceof Block) {
            Block block = (Block) obj;
            return Component.text(obj.getClass().getSimpleName())
                .append(Component.text("{"))
                .append(Component.text(block.getType().name()))
                .append(Component.text(", "))
                .append(converter(block.getLocation()))
                .append(Component.text("}"))
                .hoverEvent(HoverEvent.showText(Component.text(
                    obj.getClass().getName() + "\n" +
                        "\n" +
                        "getType.name:" + block.getType().name() + "\n" +
                        "getLocation.getWorld.getName: " + block.getLocation().getWorld().getName() + "\n" +
                        "getLocation.getX: " + block.getLocation().getX() + "\n" +
                        "getLocation.getY: " + block.getLocation().getY() + "\n" +
                        "getLocation.getZ: " + block.getLocation().getZ()
                )));
        }

        if (obj instanceof BlockState) {
            BlockState blockState = (BlockState) obj;
            return Component.text(obj.getClass().getSimpleName())
                .append(Component.text("{"))
                .append(Component.text(blockState.getType().name()))
                .append(Component.text(", "))
                .append(converter(blockState.getLocation()))
                .append(Component.text("}"))
                .hoverEvent(HoverEvent.showText(Component.text(
                    obj.getClass().getName() + "\n" +
                        "\n" +
                        "getType.name:" + blockState.getType().name() + "\n" +
                        "getLocation.getWorld.getName: " + blockState.getLocation().getWorld().getName() + "\n" +
                        "getLocation.getX: " + blockState.getLocation().getX() + "\n" +
                        "getLocation.getY: " + blockState.getLocation().getY() + "\n" +
                        "getLocation.getZ: " + blockState.getLocation().getZ()
                )));
        }

        if (obj instanceof List) {
            List<?> list = (List<?>) obj;
            TextComponent.Builder component = Component.text()
                .append(Component.text("["));
            list.stream().map(Main::converter).limit(10).forEach(c -> component.append(c, Component.space()));
            if (list.size() > 10) component.append(Component.text("..."));
            return component.append(Component.text("]"))
                .hoverEvent(HoverEvent.showText(Component.text(obj.getClass().getName() + "\n\nsize: " + list.size())))
                .build();
        }

        if (obj instanceof Set) {
            Set<?> set = (Set<?>) obj;
            TextComponent.Builder component = Component.text()
                .append(Component.text("["));
            set.stream().map(Main::converter).limit(10).forEach(c -> component.append(c, Component.space()));
            if (set.size() > 10) component.append(Component.text("..."));
            return component.append(Component.text("]"))
                .hoverEvent(HoverEvent.showText(Component.text(obj.getClass().getName() + "\n\nsize: " + set.size())))
                .build();
        }

        if (obj instanceof Class) {
            Class<?> clazz = (Class<?>) obj;
            return Component.text(clazz.getSimpleName())
                .hoverEvent(HoverEvent.showText(Component.text(obj.getClass().getName())));
        }

        if (obj == null) return Component.text("NULL", NamedTextColor.DARK_PURPLE);

        return Component.text(obj.toString())
            .hoverEvent(HoverEvent.showText(Component.text(obj.getClass().getName())));
    }

    public static NamedTextColor getNamedTextColor(String color) {
        switch (color.toUpperCase()) {
            case "BLACK":
                return NamedTextColor.BLACK;
            case "DARK_BLUE":
                return NamedTextColor.DARK_BLUE;
            case "DARK_GREEN":
                return NamedTextColor.DARK_GREEN;
            case "DARK_AQUA":
                return NamedTextColor.DARK_AQUA;
            case "DARK_RED":
                return NamedTextColor.DARK_RED;
            case "DARK_PURPLE":
                return NamedTextColor.DARK_PURPLE;
            case "GOLD":
                return NamedTextColor.GOLD;
            case "GRAY":
                return NamedTextColor.GRAY;
            case "DARK_GRAY":
                return NamedTextColor.DARK_GRAY;
            case "BLUE":
                return NamedTextColor.BLUE;
            case "GREEN":
                return NamedTextColor.GREEN;
            case "AQUA":
                return NamedTextColor.AQUA;
            case "RED":
                return NamedTextColor.RED;
            case "LIGHT_PURPLE":
                return NamedTextColor.LIGHT_PURPLE;
            case "YELLOW":
                return NamedTextColor.YELLOW;
            case "WHITE":
                return NamedTextColor.WHITE;
            default:
                return null;
        }
    }

    public void loadHidePattern() {
        hidePattern.clear();

        // 設定ファイルから一覧を読み込む
        List<?> list = conf.getList(CONF_HIDE_PATTERN);

        if (list == null) {
            return;
        }

        for (Object pattern : list) {
            addHidePattern(pattern.toString());
        }
    }

    private void initPackageColor() {
        // マップを初期化
        pkgColor.clear();

        // 設定ファイルのエントリを順に処理
        Map<?, ?> map = conf.getMapList("color").get(0);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (getNamedTextColor(entry.getValue().toString()) == null) {
                Bukkit.getServer().sendMessage(Component.text("不明な色名：" + entry.getValue().toString(), NamedTextColor.RED));
                return;
            }
            pkgColor.put(entry.getKey().toString(), getNamedTextColor(entry.getValue().toString()));
        }
    }

    boolean addHidePattern(String pattern) {
        // 小文字にする
        pattern = pattern.toLowerCase();

        // 重複は無視
        if (hidePattern.contains(pattern)) {
            return false;
        }

        hidePattern.add(pattern);
        return true;
    }

    boolean removeHidePattern(String pattern) {
        // 小文字にする
        pattern = pattern.toLowerCase();

        hidePattern.remove(pattern);
        return true;
    }

    public void setFilter(String filter) {
        Main.filter = filter;
    }
}
