package net.venturevolt.skulkatum.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.venturevolt.skulkatum.Skulkatum;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    PULSE_GEM("pulse_gem", 26, new int[]{5, 7, 5, 4},35,
            SoundEvents.SCULK_BLOCK_CHARGE, 1f, 0f, () -> Ingredient.of(ModItems.PULSE_GEM.get()));




    private final String name;
    private final  int durabilityMultiplier;
    private final int[] protectionAmount;
    private final  int enchantmentValue;
    private final SoundEvent equipSound;
    private final float knockbackResistance;
    private final  float toughness;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15 ,13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmount, int enchantmentValue, SoundEvent equipSound, float knockbackResistance, float toughness, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmount = protectionAmount;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.knockbackResistance = knockbackResistance;
        this.toughness = toughness;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmount[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Skulkatum.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
