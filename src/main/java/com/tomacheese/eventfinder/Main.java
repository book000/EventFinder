package com.tomacheese.eventfinder;

import com.tomacheese.eventfinder.listeners.*;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public final class Main extends JavaPlugin {
    private static final String CONF_HIDE_PATTERN = "hidePattern";
    private static final Map<String, NamedTextColor> pkgColor = new HashMap<>();

    private static final List<String> hidePattern = new ArrayList<>();

    private FileConfiguration conf;

    public static void showEvent(Event event) {
        Class<?> handler = event.getClass();
        TextComponent.Builder builder = Component.text();

        builder.append(Component.text(handler.getSimpleName(), pkgColor.get(event.getClass().getPackage().getName())));

        if (!event.getEventName().equals(handler.getSimpleName())) {
            builder.append(Component.text("<" + event.getEventName() + ">", NamedTextColor.WHITE));
        }

        if (Arrays.stream(event.getClass().getDeclaredFields()).map(field -> field.getAnnotation(Deprecated.class)).anyMatch(Objects::nonNull)) {
            builder.append(Component.text("*", NamedTextColor.DARK_GRAY));
        }

        builder.append(Component.text(": ", NamedTextColor.WHITE));
        Map<String, Object> details = new HashMap<>();
        Method[] methods = event.getClass().getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (!methodName.startsWith("get")) {
                continue;
            }
            if (methodName.contains("Handler")) {
                continue;
            }
            try {
                details.put(method.getName().substring(3), method.invoke(event));
            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException ignored) {
            } catch (NullPointerException e) {
                details.put(method.getName().substring(3), null);
            }
        }
        builder.append(Component.text(details.entrySet().stream()
            .peek(s -> s.setValue(converter(s.getValue())))
            .map(s -> s.getKey() + ":" + s.getValue())
            .collect(Collectors.joining(", ")), NamedTextColor.GRAY));

        String eventName = event.getEventName().toLowerCase();
        boolean isHide = hidePattern.stream().anyMatch(eventName::startsWith);
        if (isHide) {
            return;
        }

        if (event instanceof Cancellable && ((Cancellable) event).isCancelled()) {
            builder.decorate(TextDecoration.STRIKETHROUGH);
        }
        Bukkit.getServer().sendMessage(builder.build());
    }

    static String converter(Object obj) {
        if (obj instanceof Player) {
            Player player = (Player) obj;
            return player.getName();
        }
        if (obj instanceof Location) {
            Location loc = (Location) obj;
            return loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
        }
        if (obj instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) obj;
            return obj.getClass().getSimpleName() + "{" + livingEntity.getType().name() + ", " + converter(livingEntity.getLocation()) + "}";
        }
        if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            return obj.getClass().getSimpleName() + "{" + entity.getType().name() + ", " + converter(entity.getLocation()) + "}";
        }
        if (obj instanceof Block) {
            Block block = (Block) obj;
            return obj.getClass().getSimpleName() + "{" + block.getType().name() + ", " + converter(block.getLocation()) + "}";
        } else if (obj instanceof List) {
            List<?> list = (List<?>) obj;
            return "[" + list.stream().map(Main::converter).collect(Collectors.joining(", ")) + "]";
        } else if (obj instanceof Set) {
            Set<?> set = (Set<?>) obj;
            return "[" + set.stream().map(Main::converter).collect(Collectors.joining(", ")) + "]";
        }

        if (obj == null) return "NULL";
        return obj.toString();
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

    public void onEnable() {
        saveDefaultConfig();
        conf = getConfig();
        loadHidePattern();
        initPackageColor();

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

    public void showEvent(Event event, Object... detail) {
        Class<?> handler = event.getClass();
        TextComponent.Builder builder = Component.text();

        builder.append(Component.text(handler.getSimpleName(), pkgColor.get(event.getClass().getPackage().getName())));

        if (!event.getEventName().equals(handler.getSimpleName())) {
            builder.append(Component.text("<" + event.getEventName() + ">", NamedTextColor.WHITE));
        }

        if (Arrays.stream(event.getClass().getDeclaredFields()).map(field -> field.getAnnotation(Deprecated.class)).anyMatch(Objects::nonNull)) {
            builder.append(Component.text("*", NamedTextColor.DARK_GRAY));
        }

        builder.append(Component.text(": ", NamedTextColor.WHITE));
        if (detail.length == 0) {
            List<Object> details = new ArrayList<>();
            Method[] methods = event.getClass().getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                if (!methodName.startsWith("get")) {
                    continue;
                }
                try {
                    details.add(method.invoke(event.getClass()));
                } catch (IllegalAccessException | InvocationTargetException ignored) {
                }
            }
            detail = details.toArray();
        }
        builder.append(Component.text(Arrays.stream(detail).map(Main::converter).collect(Collectors.joining(", ")), NamedTextColor.DARK_GRAY));

        // イベントが非表示条件にマッチするか確認する
        String eventName = event.getEventName().toLowerCase();
        boolean isHide = hidePattern.stream().anyMatch(eventName::startsWith);
        if (isHide) {
            return;
        }

        if (event instanceof Cancellable && ((Cancellable) event).isCancelled()) {
            builder.decorate(TextDecoration.STRIKETHROUGH);
        }
        Bukkit.getServer().sendMessage(builder.build());
    }

    /**
     * コマンド実行時に呼ばれる
     */
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "引数が必要です。");
        }
        // 読み込み
        else if ("load".equalsIgnoreCase(args[0])) {
            loadHidePattern();
            sender.sendMessage(ChatColor.GREEN + "非表示条件を読み込みました。");
            listHidePattern(sender);
            return true;
        }
        // 追加
        else if (("add".equalsIgnoreCase(args[0]) || "hide".equalsIgnoreCase(args[0])) && args.length > 1) {
            int count = 0;
            for (int i = 1; i < args.length; i++) {
                if (addHidePattern(args[i])) {
                    count++;
                }
            }
            sender.sendMessage(ChatColor.GREEN + "非表示条件を" + count + "個追加しました。");
            return true;
        }
        // 削除
        else if (("del".equalsIgnoreCase(args[0]) ||
            "remove".equalsIgnoreCase(args[0]) ||
            "show".equalsIgnoreCase(args[0])) && args.length > 1) {
            int count = 0;
            for (int i = 1; i < args.length; i++) {
                if (hidePattern.remove(args[i].toLowerCase())) {
                    count++;
                }
            }
            sender.sendMessage(ChatColor.GREEN + "非表示条件を" + count + "個削除しました。");
            return true;
        }
        // 表示
        else if ("list".equalsIgnoreCase(args[0])) {
            listHidePattern(sender);
            return true;
        }
        // 保存
        else if ("save".equalsIgnoreCase(args[0])) {
            conf.set(CONF_HIDE_PATTERN, hidePattern);
            saveConfig();
            sender.sendMessage(ChatColor.GREEN + "非表示条件を保存しました。");
            return true;
        }
        // それ以外
        else {
            sender.sendMessage(ChatColor.RED + "引数が不正です。");
        }

        return false;
    }

    private void listHidePattern(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "設定されている非表示条件は" + hidePattern.size() + "個です。");
        for (String disable : hidePattern) {
            sender.sendMessage(disable);
        }
    }

    private void loadHidePattern() {
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

    private boolean addHidePattern(String pattern) {
        // 小文字にする
        pattern = pattern.toLowerCase();

        // 重複は無視
        if (hidePattern.contains(pattern)) {
            return false;
        }

        hidePattern.add(pattern);
        return true;
    }
}
