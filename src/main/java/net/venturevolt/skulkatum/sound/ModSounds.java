package net.venturevolt.skulkatum.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.venturevolt.skulkatum.Skulkatum;


public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Skulkatum.MOD_ID);

  public static final RegistryObject<SoundEvent> FALLEN_GEODE_GLOW = registerSoundEvents("fallen_geode_glow");


    public static final RegistryObject<SoundEvent> FALLEN_GEODE_SHATTER = registerSoundEvents("fallen_geode_shatter");



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Skulkatum.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
