package net.venturevolt.skulkatum.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.block.custom.ModFlammableRotatedPillarBlock;
import net.venturevolt.skulkatum.block.custom.SculkSageCropBlock;
import net.venturevolt.skulkatum.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Skulkatum.MOD_ID);


    private static <T extends  Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }
    public static final RegistryObject<Block> ECHO_LOG = registerBlock("echo_log",
    () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops().strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 3)));
    public static final RegistryObject<Block> ECHO_WOOD = registerBlock("echo_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops().strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 3)));
    public static final RegistryObject<Block> STRIPPED_ECHO_LOG = registerBlock("stripped_echo_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops().strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5)));
    public static final RegistryObject<Block> STRIPPED_ECHO_WOOD = registerBlock("stripped_echo_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops().strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5)));

    public static final RegistryObject<Block> ALYSSUM = registerBlock("alyssum",
            () -> new FlowerBlock(() -> MobEffects.GLOWING, 600 , BlockBehaviour.Properties.copy(Blocks.TORCHFLOWER).sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion().lightLevel((p_187431_) -> 5)));

    public static final RegistryObject<Block> POTTED_ALYSSUM = BLOCKS.register("potted_alyssum",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock)Blocks.FLOWER_POT), ModBlocks.ALYSSUM, BlockBehaviour.Properties.copy(Blocks.POTTED_TORCHFLOWER).noOcclusion().lightLevel((p_187431_) -> 5)));

    public static final RegistryObject<Block> ECHO_PLANKS = registerBlock("echo_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> FLOWERING_ECHO_LEAVES = registerBlock("flowering_echo_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.FLOWERING_AZALEA_LEAVES).sound(SoundType.SCULK).lightLevel((p_187431_) -> 3)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });


    public static final RegistryObject<Block> ECHO_STAIRS = registerBlock("echo_stairs",
            () -> new StairBlock(() -> ModBlocks.ECHO_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> ECHO_SLAB = registerBlock("echo_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> ECHO_BUTTON = registerBlock("echo_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5), BlockSetType.OAK, 20
                    ,true){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> ECHO_PRESSURE_PLATE = registerBlock("echo_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5),BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> ECHO_FENCE = registerBlock("echo_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> ECHO_FENCE_GATE = registerBlock("echo_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> ECHO_DOOR = registerBlock("echo_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> ECHO_TRAPDOOR = registerBlock("echo_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).strength(0.85F).sound(SoundType.SCULK).lightLevel((p_187431_) -> 5),BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> DEEPSLATE_PULSE_GEM_ORE = registerBlock("deepslate_pulse_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .requiresCorrectToolForDrops().strength(8.0F, 8.0F).lightLevel((p_187431_) -> 3), UniformInt.of(7, 10)));

    public static final RegistryObject<Block> SCULK_SAGE_CROP = BLOCKS.register("sculk_sage_crop",
            () -> new SculkSageCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noCollission().sound(SoundType.SCULK).lightLevel((p_187431_) -> 5)));



    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
