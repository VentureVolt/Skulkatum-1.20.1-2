package net.venturevolt.skulkatum.item;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.block.ModBlocks;
import net.venturevolt.skulkatum.entity.ModEntities;
import net.venturevolt.skulkatum.item.custom.FuelItem;
import net.venturevolt.skulkatum.item.custom.ModArmorItem;
import net.venturevolt.skulkatum.item.custom.ModToolTiers;
import net.venturevolt.skulkatum.item.custom.PulseSensorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Skulkatum.MOD_ID);

    public static final RegistryObject<Item> ECHO_CATALYST = ITEMS.register("echo_catalyst",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VIBROCLOTH = ITEMS.register("vibrocloth",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NIMBIUM_INGOT = ITEMS.register("nimbium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PULSE_GEM = ITEMS.register("pulse_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_PULSE_GEM = ITEMS.register("raw_pulse_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VIBRALIUM_FLOWER = ITEMS.register("vibralium_flower",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WARDEN_HORN = ITEMS.register("warden_horn",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FALLEN_GEODE = ITEMS.register("fallen_geode",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SCULK_SAGE_SEEDS = ITEMS.register("sculk_sage_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SCULK_SAGE_CROP.get(),new Item.Properties()));

    public static final RegistryObject<Item> SCULK_SAGE = ITEMS.register("sculk_sage",
            () -> new FuelItem(new Item.Properties().food(ModFoods.SCULK_SAGE), 25));

    public static final RegistryObject<Item> FALLEN_GEODE_SPAWN_EGG = ITEMS.register("fallen_geode_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FALLENGEODE, 0x1f334f , 0x5e425e, new Item.Properties()));




    public static final RegistryObject<Item> ECHO_SCYTHE = ITEMS.register("echo_scythe",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARC_EDGE = ITEMS.register("arc_edge",
            () -> new SwordItem(ModToolTiers.NIMBIUM,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> PULSE_SWORD = ITEMS.register("pulse_sword",
            () -> new SwordItem(ModToolTiers.PULSE,3, -1.9f, new Item.Properties()));
    public static final RegistryObject<Item> PULSE_HOE = ITEMS.register("pulse_hoe",
            () -> new HoeItem(ModToolTiers.PULSE, -3, 0.5f, new Item.Properties()));
    public static final RegistryObject<Item> PULSE_AXE = ITEMS.register("pulse_axe",
            () -> new AxeItem(ModToolTiers.PULSE, 5, -2.5f, new Item.Properties()));
    public static final RegistryObject<Item> PULSE_SHOVEL = ITEMS.register("pulse_shovel",
            () -> new ShovelItem(ModToolTiers.PULSE, 1.5f, -2.5f, new Item.Properties()));
    public static final RegistryObject<Item> PULSE_PICKAXE = ITEMS.register("pulse_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PULSE, 1, -2.5f, new Item.Properties()));

    public static final RegistryObject<Item> PULSE_HELMET = ITEMS.register("pulse_helmet",
            () -> new ModArmorItem(ModArmorMaterials.PULSE_GEM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PULSE_CHESTPLATE = ITEMS.register("pulse_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.PULSE_GEM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PULSE_LEGGINGS = ITEMS.register("pulse_leggings",
            () -> new ModArmorItem(ModArmorMaterials.PULSE_GEM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PULSE_BOOTS = ITEMS.register("pulse_boots",
            () -> new ModArmorItem(ModArmorMaterials.PULSE_GEM, ArmorItem.Type.BOOTS, new Item.Properties()));




    public static final RegistryObject<Item> RESONATING_MALLET = ITEMS.register("resonating_mallet",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SCULKLAW = ITEMS.register("sculklaw",
            () -> new Item(new Item.Properties().stacksTo(1).durability(1750)));

    public static final RegistryObject<Item> PULSE_SENSOR = ITEMS.register("pulse_sensor",
            () -> new PulseSensorItem(new Item.Properties().stacksTo(1).durability(256)));


    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);

        }

    }
