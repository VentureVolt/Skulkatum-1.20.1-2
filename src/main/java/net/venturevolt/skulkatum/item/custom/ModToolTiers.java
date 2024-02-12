package net.venturevolt.skulkatum.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.item.ModItems;
import net.venturevolt.skulkatum.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier PULSE = TierSortingRegistry.registerTier(
            new ForgeTier(6,1796, 12.0F, 3F, 35,
                    ModTags.Blocks.NEEDS_PULSE_TOOL, () -> Ingredient.of(ModItems.PULSE_GEM.get())),
            new ResourceLocation(Skulkatum.MOD_ID, "pulse_gem"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier NIMBIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5,2500, 20.0F, -3F, 25,
                    ModTags.Blocks.NEEDS_NIMBIUM_TOOL, () -> Ingredient.of(ModItems.NIMBIUM_INGOT.get())),
            new ResourceLocation(Skulkatum.MOD_ID, "nimbium_ingot"), List.of(Tiers.NETHERITE), List.of());
}
