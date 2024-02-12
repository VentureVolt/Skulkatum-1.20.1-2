package net.venturevolt.skulkatum.event;


import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.entity.ModEntities;
import net.venturevolt.skulkatum.entity.custom.FallenGeodeEntity;

@Mod.EventBusSubscriber(modid = Skulkatum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
      event.put(ModEntities.FALLENGEODE.get(), FallenGeodeEntity.createAttributes().build());

    }
}
