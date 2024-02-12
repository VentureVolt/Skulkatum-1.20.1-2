package net.venturevolt.skulkatum.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.block.ModBlocks;
import net.venturevolt.skulkatum.block.custom.SculkSageCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Skulkatum.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.ECHO_PLANKS);
        blockWithItem(ModBlocks.FLOWERING_ECHO_LEAVES);


        blockWithItem(ModBlocks.DEEPSLATE_PULSE_GEM_ORE);

        stairsBlock(((StairBlock) ModBlocks.ECHO_STAIRS.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.ECHO_SLAB.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.ECHO_BUTTON.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ECHO_PRESSURE_PLATE.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.ECHO_FENCE.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.ECHO_FENCE_GATE.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.ECHO_DOOR.get()),modLoc("block/echo_door_bottom"), modLoc("block/echo_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ECHO_TRAPDOOR.get()),modLoc("block/echo_trapdoor"), true, "cutout");

        makeSculkSageCrop((CropBlock) ModBlocks.SCULK_SAGE_CROP.get(), "sculk_sage_stage", "sculk_sage_stage");

        simpleBlockWithItem(ModBlocks.ALYSSUM.get(), models().cross(blockTexture(ModBlocks.ALYSSUM.get()).getPath(),
                blockTexture(ModBlocks.ALYSSUM.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_ALYSSUM.get(), models().singleTexture("potted_alyssum", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.ALYSSUM.get())).renderType("cutout"));
    }
    public void makeSculkSageCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> SculkSageStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] SculkSageStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SculkSageCropBlock) block).getAgeProperty()),
                new ResourceLocation(Skulkatum.MOD_ID, "block/" + textureName + state.getValue(((SculkSageCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}