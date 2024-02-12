package net.venturevolt.skulkatum.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Skulkatum.MOD_ID);

            public static final RegistryObject<CreativeModeTab> SKULKATUM_TAB = CREATIVE_MODE_TABS.register("skulkatum_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECHO_CATALYST.get()))
                            .title(Component.translatable("creativetab.skulkatum_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.ECHO_CATALYST.get());
                                pOutput.accept(ModItems.VIBROCLOTH.get());
                                pOutput.accept(ModItems.ECHO_SCYTHE.get());
                                pOutput.accept(ModItems.ARC_EDGE.get());
                                pOutput.accept(ModItems.RESONATING_MALLET.get());
                                pOutput.accept(ModItems.SCULKLAW.get());
                                pOutput.accept(ModItems.PULSE_SENSOR.get());
                                pOutput.accept(ModItems.FALLEN_GEODE.get());
                                pOutput.accept(ModItems.SCULK_SAGE_SEEDS.get());
                                pOutput.accept(ModItems.NIMBIUM_INGOT.get());
                                pOutput.accept(ModItems.WARDEN_HORN.get());
                                pOutput.accept(ModItems.SCULK_SAGE.get());
                                pOutput.accept(ModItems.PULSE_GEM.get());
                                pOutput.accept(ModItems.RAW_PULSE_GEM.get());
                                pOutput.accept(ModItems.VIBRALIUM_FLOWER.get());
                                pOutput.accept(ModItems.PULSE_HOE.get());
                                pOutput.accept(ModItems.PULSE_SWORD.get());
                                pOutput.accept(ModItems.PULSE_AXE.get());
                                pOutput.accept(ModItems.PULSE_SHOVEL.get());
                                pOutput.accept(ModItems.PULSE_PICKAXE.get());
                                pOutput.accept(ModItems.PULSE_HELMET.get());
                                pOutput.accept(ModItems.PULSE_CHESTPLATE.get());
                                pOutput.accept(ModItems.PULSE_LEGGINGS.get());
                                pOutput.accept(ModItems.PULSE_BOOTS.get());
                                pOutput.accept(ModItems.FALLEN_GEODE_SPAWN_EGG.get());
                                pOutput.accept(ModBlocks.ECHO_LOG.get());
                                pOutput.accept(ModBlocks.ECHO_WOOD.get());
                                pOutput.accept(ModBlocks.STRIPPED_ECHO_LOG.get());
                                pOutput.accept(ModBlocks.STRIPPED_ECHO_WOOD.get());
                                pOutput.accept(ModBlocks.ECHO_PLANKS.get());
                                pOutput.accept(ModBlocks.FLOWERING_ECHO_LEAVES.get());
                                pOutput.accept(ModBlocks.DEEPSLATE_PULSE_GEM_ORE.get());
                                pOutput.accept(ModBlocks.ECHO_STAIRS.get());
                                pOutput.accept(ModBlocks.ECHO_SLAB.get());
                                pOutput.accept(ModBlocks.ECHO_DOOR.get());
                                pOutput.accept(ModBlocks.ECHO_TRAPDOOR.get());
                                pOutput.accept(ModBlocks.ECHO_FENCE.get());
                                pOutput.accept(ModBlocks.ECHO_FENCE_GATE.get());
                                pOutput.accept(ModBlocks.ECHO_BUTTON.get());
                                pOutput.accept(ModBlocks.ALYSSUM.get());







                            })
                                    .build());
            public static void register(IEventBus eventBus) {
                CREATIVE_MODE_TABS.register(eventBus);
            }
}
