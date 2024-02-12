package net.venturevolt.skulkatum.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.block.ModBlocks;
import net.venturevolt.skulkatum.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Skulkatum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.PulseSensorItem)
                .add(ModBlocks.DEEPSLATE_PULSE_GEM_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.ECHO_PLANKS.get(),
                ModBlocks.ECHO_LOG.get(),
                ModBlocks.STRIPPED_ECHO_LOG.get(),
                ModBlocks.ECHO_WOOD.get(),
                ModBlocks.STRIPPED_ECHO_WOOD.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.FLOWERING_ECHO_LEAVES.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DEEPSLATE_PULSE_GEM_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.DEEPSLATE_PULSE_GEM_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ECHO_PLANKS.get(),
                        ModBlocks.ECHO_LOG.get(),
                        ModBlocks.STRIPPED_ECHO_LOG.get(),
                        ModBlocks.ECHO_WOOD.get(),
                        ModBlocks.STRIPPED_ECHO_WOOD.get()
                        );

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.ECHO_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ECHO_FENCE_GATE.get());

    }
}
