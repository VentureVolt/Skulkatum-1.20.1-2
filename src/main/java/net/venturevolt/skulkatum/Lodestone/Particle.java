package net.venturevolt.skulkatum.Lodestone;

import net.minecraft.client.*;
import net.minecraft.client.player.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import team.lodestar.lodestone.registry.common.particle.*;
import team.lodestar.lodestone.systems.easing.*;
import team.lodestar.lodestone.systems.particle.builder.*;
import team.lodestar.lodestone.systems.particle.data.*;
import team.lodestar.lodestone.systems.particle.data.color.*;
import team.lodestar.lodestone.systems.particle.data.spin.*;

import java.awt.*;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Particle {

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
        final LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            spawnExampleParticles(player.level(), player.position());
        }
    }

    public static void spawnExampleParticles(Level level, Vec3 pos) {
        Color startingColor = new Color(255, 234, 0);
        Color endingColor = new Color(255, 255, 255);
        WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
                .setScaleData(GenericParticleData.create(.5f, 0).build())
                .setTransparencyData(GenericParticleData.create(0.75f, 0.25f).build())
                .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
                .setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((level.getGameTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
                .setLifetime(100)
                .addMotion(0, -0.1f, 0)
                .enableNoClip()
                .spawn(level, pos.x, pos.y - 5, pos.z);
    }
}