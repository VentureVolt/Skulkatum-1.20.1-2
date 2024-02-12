package net.venturevolt.skulkatum.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.venturevolt.skulkatum.util.ModTags;

import static net.minecraft.client.renderer.texture.MissingTextureAtlasSprite.getLocation;
import static net.minecraftforge.client.ForgeHooksClient.playSound;
import static org.apache.commons.lang3.RandomUtils.nextFloat;

public class PulseSensorItem extends Item {
    public PulseSensorItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int Dx = 8; Dx >= -8; Dx--) {
                for (int Dy = 8; Dy >= -8; Dy--) {
                    for (int Dz = 8; Dz >= -8; Dz--) {


                        BlockState state = pContext.getLevel().getBlockState((positionClicked.offset(Dx, Dy, Dz)));

                        if (isValueableBlock(state)) {
                            SensorFoundPulse(positionClicked.offset(Dx, Dy, Dz), player, state.getBlock());
                            foundBlock = true;
                            break;

                        }
                    }
                    if (!foundBlock) {
                        player.sendSystemMessage(Component.literal("..."));
                    }
                }
            }
        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

    return InteractionResult.SUCCESS;

}
    private void SensorFoundPulse(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"));

    }

    private boolean isValueableBlock(BlockState state) {
        return state.is(ModTags.Blocks.PulseSensorItem);
    }
}
