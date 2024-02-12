package net.venturevolt.skulkatum.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationDefinitions {
    public static final AnimationDefinition CRASHED = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("fallengeode",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("fallengeode",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(33.04f, 33f, -335.82f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("fallengeode",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1.03f, 1.03f, 1.03f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.CATMULLROM))).build();
    public static final AnimationDefinition FALLING = AnimationDefinition.Builder.withLength(1.25f).looping()
            .addAnimation("fallengeode",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(360f, 360f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(0.5f).looping()
            .addAnimation("fallengeode",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-120f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-115f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-100f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(-37f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-16f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-8f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
