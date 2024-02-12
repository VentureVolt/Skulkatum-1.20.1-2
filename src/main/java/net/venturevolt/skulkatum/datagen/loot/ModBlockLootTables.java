package net.venturevolt.skulkatum.datagen.loot;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fml.common.Mod;
import net.venturevolt.skulkatum.block.ModBlocks;
import net.venturevolt.skulkatum.block.custom.SculkSageCropBlock;
import net.venturevolt.skulkatum.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ECHO_PLANKS.get());
        this.dropSelf(ModBlocks.ECHO_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ECHO_WOOD.get());
        this.dropSelf(ModBlocks.ECHO_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ECHO_LOG.get());
        this.dropSelf(ModBlocks.FLOWERING_ECHO_LEAVES.get());
        this.dropSelf(ModBlocks.ECHO_STAIRS.get());
        this.dropSelf(ModBlocks.ECHO_BUTTON.get());
        this.dropSelf(ModBlocks.ECHO_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ECHO_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ECHO_FENCE.get());
        this.dropSelf(ModBlocks.ECHO_FENCE_GATE.get());

        this.add(ModBlocks.ECHO_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ECHO_SLAB.get()));
        this.add(ModBlocks.ECHO_DOOR.get(),
                block -> createDoorTable(ModBlocks.ECHO_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SCULK_SAGE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SculkSageCropBlock.AGE, 3));

        this.add(ModBlocks.SCULK_SAGE_CROP.get(), createCropDrops(ModBlocks.SCULK_SAGE_CROP.get(), ModItems.SCULK_SAGE.get(),
                ModItems.SCULK_SAGE_SEEDS.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.ALYSSUM.get());
        this.add(ModBlocks.POTTED_ALYSSUM.get(), createPotFlowerItemTable(ModBlocks.ALYSSUM.get()));








        this.add(ModBlocks.DEEPSLATE_PULSE_GEM_ORE.get(),
                block -> createBulkyOreDrop(ModBlocks.DEEPSLATE_PULSE_GEM_ORE.get(), ModItems.RAW_PULSE_GEM.get()));


    }
    protected LootTable.Builder createBulkyOreDrop(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}