package net.venturevolt.skulkatum.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.venturevolt.skulkatum.Skulkatum;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PulseSensorItem = tag("pulsesensoritem");
        public static final TagKey<Block> NEEDS_NIMBIUM_TOOL = tag("need_nimbium_tool");
        public static final TagKey<Block> NEEDS_PULSE_TOOL = tag("need_pulse_tool");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Skulkatum.MOD_ID, name));
        }

    }
    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Skulkatum.MOD_ID, name));
        }
    }
}
