package net.venturevolt.skulkatum.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SCULK_SAGE = new FoodProperties.Builder().nutrition(1)
            .fast().effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 0), 0.4F).build();
    }
