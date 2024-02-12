package net.venturevolt.skulkatum.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.entity.client.FallenGeodeModel;
import net.venturevolt.skulkatum.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = Skulkatum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.FALLENGEODE_LAYER, FallenGeodeModel::createBodyLayer);
    }
}
