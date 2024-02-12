package net.venturevolt.skulkatum.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.venturevolt.skulkatum.Skulkatum;
import net.venturevolt.skulkatum.entity.custom.FallenGeodeEntity;

public class FallenGeodeRenderer extends MobRenderer<FallenGeodeEntity, FallenGeodeModel<FallenGeodeEntity>> {
    public FallenGeodeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FallenGeodeModel<>(pContext.bakeLayer(ModModelLayers.FALLENGEODE_LAYER)), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(FallenGeodeEntity pEntity) {
        return new ResourceLocation(Skulkatum.MOD_ID, "textures/entity/fallen_geode3d.png");
    }

    @Override
    public void render(FallenGeodeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
