package net.venturevolt.skulkatum.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.venturevolt.skulkatum.entity.ModEntities;
import net.venturevolt.skulkatum.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class FallenGeodeEntity extends Animal {

    public FallenGeodeEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
        private void setupAnimationStates() {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
        }



    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.COOKED_BEEF), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.JUMP_STRENGTH, 1 )
                .add(Attributes.FOLLOW_RANGE, 16 )
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.MAX_HEALTH, 1000)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1000000);
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.FALLENGEODE.get().create(pLevel);
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.FALLEN_GEODE_SHATTER.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.FALLEN_GEODE_GLOW.get();
    }
}

