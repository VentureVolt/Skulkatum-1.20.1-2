package net.venturevolt.skulkatum.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.venturevolt.skulkatum.entity.animations.ModAnimationDefinitions;
import net.venturevolt.skulkatum.entity.custom.FallenGeodeEntity;

public class FallenGeodeModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart fallengeode;
	private final ModelPart head;

	public FallenGeodeModel(ModelPart root) {
		this.fallengeode = root.getChild("fallengeode");
		this.head = fallengeode.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition;
		meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fallengeode = partdefinition.addOrReplaceChild("fallengeode", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition head = fallengeode.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.CRASHED, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((FallenGeodeEntity) entity).idleAnimationState, ModAnimationDefinitions.FALLING, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		fallengeode.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {

		return fallengeode;
	}
}