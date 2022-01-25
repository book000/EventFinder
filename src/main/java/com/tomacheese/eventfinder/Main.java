package com.tomacheese.eventfinder;

import com.tomacheese.eventfinder.listeners.*;
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
        Set<Listener> listeners = new HashSet<Listener>() {{
            add(new OnAbstractChatEvent());
            add(new OnAnvilDamagedEvent());
            add(new OnAreaEffectCloudApplyEvent());
            add(new OnArrowBodyCountChangeEvent());
            add(new OnAsyncChatEvent());
            add(new OnAsyncPlayerChatEvent());
            add(new OnAsyncPlayerPreLoginEvent());
            add(new OnAsyncTabCompleteEvent());
            add(new OnBatToggleSleepEvent());
            add(new OnBeaconEffectEvent());
            add(new OnBellRingEvent());
            add(new OnBlockBreakEvent());
            add(new OnBlockBurnEvent());
            add(new OnBlockCanBuildEvent());
            add(new OnBlockCookEvent());
            add(new OnBlockDamageEvent());
            add(new OnBlockDestroyEvent());
            add(new OnBlockDispenseArmorEvent());
            add(new OnBlockDispenseEvent());
            add(new OnBlockDropItemEvent());
            add(new OnBlockEvent());
            add(new OnBlockExpEvent());
            add(new OnBlockExplodeEvent());
            add(new OnBlockFadeEvent());
            add(new OnBlockFailedDispenseEvent());
            add(new OnBlockFertilizeEvent());
            add(new OnBlockFormEvent());
            add(new OnBlockFromToEvent());
            add(new OnBlockGrowEvent());
            add(new OnBlockIgniteEvent());
            add(new OnBlockMultiPlaceEvent());
            add(new OnBlockPhysicsEvent());
            add(new OnBlockPistonEvent());
            add(new OnBlockPistonExtendEvent());
            add(new OnBlockPistonRetractEvent());
            add(new OnBlockPlaceEvent());
            add(new OnBlockPreDispenseEvent());
            add(new OnBlockRedstoneEvent());
            add(new OnBlockShearEntityEvent());
            add(new OnBlockSpreadEvent());
            add(new OnBrewEvent());
            add(new OnBrewingStandFuelEvent());
            add(new OnBroadcastMessageEvent());
            add(new OnCauldronLevelChangeEvent());
            add(new OnChatEvent());
            add(new OnChunkEvent());
            add(new OnChunkLoadEvent());
            add(new OnChunkPopulateEvent());
            add(new OnChunkUnloadEvent());
            add(new OnCraftItemEvent());
            add(new OnCreatureSpawnEvent());
            add(new OnCreeperIgniteEvent());
            add(new OnCreeperPowerEvent());
            add(new OnDragonEggFormEvent());
            add(new OnEnchantItemEvent());
            add(new OnEnderDragonChangePhaseEvent());
            add(new OnEnderDragonFireballHitEvent());
            add(new OnEnderDragonFlameEvent());
            add(new OnEnderDragonShootFireballEvent());
            add(new OnEndermanAttackPlayerEvent());
            add(new OnEndermanEscapeEvent());
            add(new OnEntityAddToWorldEvent());
            add(new OnEntityAirChangeEvent());
            add(new OnEntityBlockFormEvent());
            add(new OnEntityBreakDoorEvent());
            add(new OnEntityBreedEvent());
            add(new OnEntityChangeBlockEvent());
            add(new OnEntityCombustByBlockEvent());
            add(new OnEntityCombustByEntityEvent());
            add(new OnEntityCombustEvent());
            add(new OnEntityCreatePortalEvent());
            add(new OnEntityDamageByBlockEvent());
            add(new OnEntityDamageByEntityEvent());
            add(new OnEntityDamageEvent());
            add(new OnEntityDeathEvent());
            add(new OnEntityDismountEvent());
            add(new OnEntityDropItemEvent());
            add(new OnEntityEnterBlockEvent());
            add(new OnEntityEnterLoveModeEvent());
            add(new OnEntityEvent());
            add(new OnEntityExhaustionEvent());
            add(new OnEntityExplodeEvent());
            add(new OnEntityInteractEvent());
            add(new OnEntityJumpEvent());
            add(new OnEntityKnockbackByEntityEvent());
            add(new OnEntityLoadCrossbowEvent());
            add(new OnEntityMountEvent());
            add(new OnEntityMoveEvent());
            add(new OnEntityPathfindEvent());
            add(new OnEntityPickupItemEvent());
            add(new OnEntityPlaceEvent());
            add(new OnEntityPortalEnterEvent());
            add(new OnEntityPortalEvent());
            add(new OnEntityPortalExitEvent());
            add(new OnEntityPoseChangeEvent());
            add(new OnEntityPotionEffectEvent());
            add(new OnEntityRegainHealthEvent());
            add(new OnEntityRemoveFromWorldEvent());
            add(new OnEntityResurrectEvent());
            add(new OnEntityShootBowEvent());
            add(new OnEntitySpawnEvent());
            add(new OnEntitySpellCastEvent());
            add(new OnEntityTameEvent());
            add(new OnEntityTargetEvent());
            add(new OnEntityTargetLivingEntityEvent());
            add(new OnEntityTeleportEndGatewayEvent());
            add(new OnEntityTeleportEvent());
            add(new OnEntityToggleGlideEvent());
            add(new OnEntityToggleSwimEvent());
            add(new OnEntityTransformedEvent());
            add(new OnEntityTransformEvent());
            add(new OnEntityUnleashEvent());
            add(new OnEntityZapEvent());
            add(new OnEvent());
            add(new OnExpBottleEvent());
            add(new OnExperienceOrbMergeEvent());
            add(new OnExplosionPrimeEvent());
            add(new OnFillProfileEvent());
            add(new OnFireworkExplodeEvent());
            add(new OnFluidLevelChangeEvent());
            add(new OnFoodLevelChangeEvent());
            add(new OnFurnaceBurnEvent());
            add(new OnFurnaceExtractEvent());
            add(new OnFurnaceSmeltEvent());
            add(new OnGS4QueryEvent());
            add(new OnHangingBreakByEntityEvent());
            add(new OnHangingBreakEvent());
            add(new OnHangingEvent());
            add(new OnHangingPlaceEvent());
            add(new OnHorseJumpEvent());
            add(new OnIllegalPacketEvent());
            add(new OnInventoryClickEvent());
            add(new OnInventoryCloseEvent());
            add(new OnInventoryCreativeEvent());
            add(new OnInventoryDragEvent());
            add(new OnInventoryEvent());
            add(new OnInventoryInteractEvent());
            add(new OnInventoryMoveItemEvent());
            add(new OnInventoryOpenEvent());
            add(new OnInventoryPickupItemEvent());
            add(new OnItemDespawnEvent());
            add(new OnItemMergeEvent());
            add(new OnItemSpawnEvent());
            add(new OnLeavesDecayEvent());
            add(new OnLightningStrikeEvent());
            add(new OnLingeringPotionSplashEvent());
            add(new OnLookupProfileEvent());
            add(new OnLootableInventoryReplenishEvent());
            add(new OnLootGenerateEvent());
            add(new OnMapInitializeEvent());
            add(new OnMoistureChangeEvent());
            add(new OnNotePlayEvent());
            add(new OnPaperServerListPingEvent());
            add(new OnPhantomPreSpawnEvent());
            add(new OnPigZapEvent());
            add(new OnPigZombieAngerEvent());
            add(new OnPlayerAdvancementCriterionGrantEvent());
            add(new OnPlayerAdvancementDoneEvent());
            add(new OnPlayerAnimationEvent());
            add(new OnPlayerArmorChangeEvent());
            add(new OnPlayerArmorStandManipulateEvent());
            add(new OnPlayerAttackEntityCooldownResetEvent());
            add(new OnPlayerAttemptPickupItemEvent());
            add(new OnPlayerBedEnterEvent());
            add(new OnPlayerBedLeaveEvent());
            add(new OnPlayerBucketEmptyEvent());
            add(new OnPlayerBucketEvent());
            add(new OnPlayerBucketFillEvent());
            add(new OnPlayerChangeBeaconEffectEvent());
            add(new OnPlayerChangedMainHandEvent());
            add(new OnPlayerChangedWorldEvent());
            add(new OnPlayerChannelEvent());
            add(new OnPlayerChatEvent());
            add(new OnPlayerChatTabCompleteEvent());
            add(new OnPlayerChunkLoadEvent());
            add(new OnPlayerChunkUnloadEvent());
            add(new OnPlayerClientOptionsChangeEvent());
            add(new OnPlayerCommandPreprocessEvent());
            add(new OnPlayerCommandSendEvent());
            add(new OnPlayerConnectionCloseEvent());
            add(new OnPlayerDeathEvent());
            add(new OnPlayerDropItemEvent());
            add(new OnPlayerEditBookEvent());
            add(new OnPlayerEggThrowEvent());
            add(new OnPlayerElytraBoostEvent());
            add(new OnPlayerEvent());
            add(new OnPlayerExpChangeEvent());
            add(new OnPlayerFishEvent());
            add(new OnPlayerFlowerPotManipulateEvent());
            add(new OnPlayerGameModeChangeEvent());
            add(new OnPlayerHandshakeEvent());
            add(new OnPlayerHarvestBlockEvent());
            add(new OnPlayerInitialSpawnEvent());
            add(new OnPlayerInteractAtEntityEvent());
            add(new OnPlayerInteractEntityEvent());
            add(new OnPlayerInteractEvent());
            add(new OnPlayerItemBreakEvent());
            add(new OnPlayerItemConsumeEvent());
            add(new OnPlayerItemCooldownEvent());
            add(new OnPlayerItemDamageEvent());
            add(new OnPlayerItemHeldEvent());
            add(new OnPlayerItemMendEvent());
            add(new OnPlayerJoinEvent());
            add(new OnPlayerJumpEvent());
            add(new OnPlayerKickEvent());
            add(new OnPlayerLaunchProjectileEvent());
            add(new OnPlayerLeashEntityEvent());
            add(new OnPlayerLecternPageChangeEvent());
            add(new OnPlayerLevelChangeEvent());
            add(new OnPlayerLocaleChangeEvent());
            add(new OnPlayerLocaleChangeEvent());
            add(new OnPlayerLoginEvent());
            add(new OnPlayerLoomPatternSelectEvent());
            add(new OnPlayerMoveEvent());
            add(new OnPlayerNameEntityEvent());
            add(new OnPlayerNaturallySpawnCreaturesEvent());
            add(new OnPlayerPickupArrowEvent());
            add(new OnPlayerPickupExperienceEvent());
            add(new OnPlayerPickupItemEvent());
            add(new OnPlayerPortalEvent());
            add(new OnPlayerPostRespawnEvent());
            add(new OnPlayerPreLoginEvent());
            add(new OnPlayerQuitEvent());
            add(new OnPlayerReadyArrowEvent());
            add(new OnPlayerRecipeBookClickEvent());
            add(new OnPlayerRecipeDiscoverEvent());
            add(new OnPlayerRegisterChannelEvent());
            add(new OnPlayerResourcePackStatusEvent());
            add(new OnPlayerRespawnEvent());
            add(new OnPlayerRiptideEvent());
            add(new OnPlayerShearBlockEvent());
            add(new OnPlayerShearEntityEvent());
            add(new OnPlayerSpawnLocationEvent());
            add(new OnPlayerStartSpectatingEntityEvent());
            add(new OnPlayerStatisticIncrementEvent());
            add(new OnPlayerStonecutterRecipeSelectEvent());
            add(new OnPlayerStopSpectatingEntityEvent());
            add(new OnPlayerSwapHandItemsEvent());
            add(new OnPlayerTakeLecternBookEvent());
            add(new OnPlayerTeleportEndGatewayEvent());
            add(new OnPlayerTeleportEvent());
            add(new OnPlayerToggleFlightEvent());
            add(new OnPlayerToggleSneakEvent());
            add(new OnPlayerToggleSprintEvent());
            add(new OnPlayerTradeEvent());
            add(new OnPlayerUnleashEntityEvent());
            add(new OnPlayerUnregisterChannelEvent());
            add(new OnPlayerUseUnknownEntityEvent());
            add(new OnPlayerVelocityEvent());
            add(new OnPluginDisableEvent());
            add(new OnPluginEnableEvent());
            add(new OnPluginEvent());
            add(new OnPortalCreateEvent());
            add(new OnPotionSplashEvent());
            add(new OnPreCreatureSpawnEvent());
            add(new OnPreFillProfileEvent());
            add(new OnPreLookupProfileEvent());
            add(new OnPrepareAnvilEvent());
            add(new OnPrepareGrindstoneEvent());
            add(new OnPrepareItemCraftEvent());
            add(new OnPrepareItemEnchantEvent());
            add(new OnPrepareResultEvent());
            add(new OnPrepareSmithingEvent());
            add(new OnPreSpawnerSpawnEvent());
            add(new OnProfileWhitelistVerifyEvent());
            add(new OnProjectileCollideEvent());
            add(new OnProjectileHitEvent());
            add(new OnProjectileLaunchEvent());
            add(new OnRaidEvent());
            add(new OnRaidFinishEvent());
            add(new OnRaidSpawnWaveEvent());
            add(new OnRaidStopEvent());
            add(new OnRaidTriggerEvent());
            add(new OnRemoteServerCommandEvent());
            add(new OnServerCommandEvent());
            add(new OnServerEvent());
            add(new OnServerExceptionEvent());
            add(new OnServerListPingEvent());
            add(new OnServerLoadEvent());
            add(new OnServerResourcesReloadedEvent());
            add(new OnServerTickEndEvent());
            add(new OnServerTickStartEvent());
            add(new OnServiceEvent());
            add(new OnServiceRegisterEvent());
            add(new OnServiceUnregisterEvent());
            add(new OnSheepDyeWoolEvent());
            add(new OnSheepRegrowWoolEvent());
            add(new OnSignChangeEvent());
            add(new OnSkeletonHorseTrapEvent());
            add(new OnSlimeChangeDirectionEvent());
            add(new OnSlimePathfindEvent());
            add(new OnSlimeSplitEvent());
            add(new OnSlimeSwimEvent());
            add(new OnSlimeTargetLivingEntityEvent());
            add(new OnSlimeWanderEvent());
            add(new OnSpawnChangeEvent());
            add(new OnSpawnerSpawnEvent());
            add(new OnSpongeAbsorbEvent());
            add(new OnStriderTemperatureChangeEvent());
            add(new OnStructureGrowEvent());
            add(new OnStructureLocateEvent());
            add(new OnTabCompleteEvent());
            add(new OnTargetHitEvent());
            add(new OnThrownEggHatchEvent());
            add(new OnThunderChangeEvent());
            add(new OnTimeSkipEvent());
            add(new OnTNTPrimeEvent());
            add(new OnTradeSelectEvent());
            add(new OnTurtleGoHomeEvent());
            add(new OnTurtleLayEggEvent());
            add(new OnTurtleStartDiggingEvent());
            add(new OnUnknownCommandEvent());
            add(new OnVehicleBlockCollisionEvent());
            add(new OnVehicleCollisionEvent());
            add(new OnVehicleCreateEvent());
            add(new OnVehicleDamageEvent());
            add(new OnVehicleDestroyEvent());
            add(new OnVehicleEnterEvent());
            add(new OnVehicleEntityCollisionEvent());
            add(new OnVehicleEvent());
            add(new OnVehicleExitEvent());
            add(new OnVehicleMoveEvent());
            add(new OnVehicleUpdateEvent());
            add(new OnVillagerAcquireTradeEvent());
            add(new OnVillagerCareerChangeEvent());
            add(new OnVillagerReplenishTradeEvent());
            add(new OnWeatherChangeEvent());
            add(new OnWeatherEvent());
            add(new OnWhitelistToggleEvent());
            add(new OnWitchConsumePotionEvent());
            add(new OnWitchReadyPotionEvent());
            add(new OnWitchThrowPotionEvent());
            add(new OnWorldBorderBoundsChangeEvent());
            add(new OnWorldBorderBoundsChangeFinishEvent());
            add(new OnWorldBorderCenterChangeEvent());
            add(new OnWorldBorderEvent());
            add(new OnWorldEvent());
            add(new OnWorldGameRuleChangeEvent());
            add(new OnWorldInitEvent());
            add(new OnWorldLoadEvent());
            add(new OnWorldSaveEvent());
            add(new OnWorldUnloadEvent());
        }};
        for (Listener listener : listeners) {
            try {
                getServer().getPluginManager().registerEvents(listener, this);
            } catch (IllegalPluginAccessException e) {
                getLogger().warning("Register failed: " + listener.getClass().getSimpleName());
            }
        }
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
