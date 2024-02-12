package net.venturevolt.skulkatum.datagen;

import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.common.Mod;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.block.ModBlocks;
import net.venturevolt.skulkatum.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    private static final List<ItemLike>
            PULSE_SMELTABLES = List.of(ModBlocks.DEEPSLATE_PULSE_GEM_ORE.get(), ModItems.RAW_PULSE_GEM.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, PULSE_SMELTABLES, RecipeCategory.MISC, ModItems.PULSE_GEM.get(), 10.0F, 250, "pulse_gem" );
        oreSmelting(pWriter, PULSE_SMELTABLES, RecipeCategory.MISC, ModItems.PULSE_GEM.get(), 10.0F, 500, "pulse_gem" );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_CATALYST.get())
                .pattern("PEP")
                .pattern("HCH")
                .pattern("PEP")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .define('C', Items.SCULK_CATALYST)
                .define('H', ModItems.WARDEN_HORN.get())
                .unlockedBy(getHasName(ModItems.ECHO_CATALYST.get()), has(ModItems.ECHO_CATALYST.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" E ")
                .pattern(" E ")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_PICKAXE.get()), has(ModItems.PULSE_PICKAXE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_SHOVEL.get())
                .pattern(" P ")
                .pattern(" E ")
                .pattern(" E ")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_SHOVEL.get()), has(ModItems.PULSE_SHOVEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_AXE.get())
                .pattern("PP")
                .pattern("PE")
                .pattern(" E")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_AXE.get()), has(ModItems.PULSE_AXE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_HOE.get())
                .pattern("PP")
                .pattern(" E")
                .pattern(" E")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_HOE.get()), has(ModItems.PULSE_HOE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" E ")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_SWORD.get()), has(ModItems.PULSE_SWORD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_BOOTS.get())
                .pattern("   ")
                .pattern("E E")
                .pattern("P P")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_BOOTS.get()), has(ModItems.PULSE_BOOTS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_LEGGINGS.get())
                .pattern("EEE")
                .pattern("P P")
                .pattern("P P")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_LEGGINGS.get()), has(ModItems.PULSE_LEGGINGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_HELMET.get())
                .pattern("EEE")
                .pattern("P P")
                .pattern("   ")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.PULSE_HELMET.get()), has(ModItems.PULSE_HELMET.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PULSE_CHESTPLATE.get())
                .pattern("E E")
                .pattern("PCP")
                .pattern("PPP")
                .define('P', ModItems.PULSE_GEM.get())
                .define('E', Items.ECHO_SHARD)
                .define('C', ModItems.ECHO_CATALYST.get())
                .unlockedBy(getHasName(ModItems.PULSE_CHESTPLATE.get()), has(ModItems.PULSE_CHESTPLATE.get()))
                .save(pWriter);





    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Skulkatum.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}