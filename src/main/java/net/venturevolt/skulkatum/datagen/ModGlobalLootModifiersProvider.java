package net.venturevolt.skulkatum.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.item.ModItems;
import net.venturevolt.skulkatum.loot.AddItemModifier;
import net.venturevolt.skulkatum.loot.AddSusSandItemModifierCommon;
import net.venturevolt.skulkatum.loot.AddSusSandItemModifierRare;
import net.venturevolt.skulkatum.loot.AddSusSandItemModifierUncommon;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Skulkatum.MOD_ID);
    }

    @Override
    protected void start() {
        add("warden_horn_from_warden", new AddItemModifier( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("entities/warden")).build(), }, ModItems.WARDEN_HORN.get()));

        add("pulse_gem_in_ancient_city", new AddItemModifier( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("chests/ancient_city")).build() }, ModItems.PULSE_GEM.get()));

        add("pulse_gem_in_ancient_city_ice_box", new AddItemModifier( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("chests/ancient_city_ice_box")).build() }, ModItems.PULSE_GEM.get()));

        add("fallen_geode_in_trail_ruins_common", new AddSusSandItemModifierCommon( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("archaeology/trail_ruins_common")).build() }, ModItems.FALLEN_GEODE.get()));

        add("fallen_geode_in_trail_runes_rare", new AddSusSandItemModifierCommon( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("archaeology/trail_ruins_rare")).build() }, ModItems.FALLEN_GEODE.get()));

        add("fallen_geode_in_desert_temple", new AddSusSandItemModifierCommon( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("archaeology/desert_temple")).build() }, ModItems.FALLEN_GEODE.get()));

        add("fallen_geode_in_desert_temple", new AddSusSandItemModifierCommon( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("archaeology/desert_well")).build() }, ModItems.FALLEN_GEODE.get()));

        add("fallen_geode_in_ocean_ruin_cold", new AddSusSandItemModifierCommon( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("archaeology/ocean_ruin_cold")).build() }, ModItems.FALLEN_GEODE.get()));

        add("fallen_geode_in_ocean_ruin_warm", new AddSusSandItemModifierCommon( new LootItemCondition[] {
                new LootTableIdCondition.Builder(new  ResourceLocation("archaeology/ocean_ruin_warm")).build() }, ModItems.FALLEN_GEODE.get()));
    }
}
