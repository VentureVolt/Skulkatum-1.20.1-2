package net.venturevolt.skulkatum.entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.entity.custom.FallenGeodeEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Skulkatum.MOD_ID);

    public static final RegistryObject<EntityType<FallenGeodeEntity>> FALLENGEODE =
            ENTITY_TYPES.register("fallengeode", () -> EntityType.Builder.of(FallenGeodeEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1).build("fallengeode"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
