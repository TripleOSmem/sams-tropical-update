package net.sam.tropicalupdate.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.sam.tropicalupdate.entity.animation.ModAnimations;
import net.sam.tropicalupdate.entity.custom.CrabEntity;


public class CrabModel<T extends CrabEntity> extends EntityModel<T>{
	private final ModelPart crabby;

	public CrabModel(ModelPart root) {
		this.crabby = root.getChild("crabby");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData crabby = modelPartData.addChild("crabby", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = crabby.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -2.0F, 6.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData leg1 = crabby.addChild("leg1", ModelPartBuilder.create().uv(0, 8).cuboid(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, -1.0F));
		ModelPartData leg2 = crabby.addChild("leg2", ModelPartBuilder.create().uv(0, 8).cuboid(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, 1.0F));
		ModelPartData leg3 = crabby.addChild("leg3", ModelPartBuilder.create().uv(0, 8).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, -1.0F));
		ModelPartData leg4 = crabby.addChild("leg4", ModelPartBuilder.create().uv(0, 8).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 1.0F));

		ModelPartData leftclaw = crabby.addChild("leftclaw", ModelPartBuilder.create().uv(0, 12).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(1, 13).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -2.0F, -3.0F));

		ModelPartData rightclaw = crabby.addChild("rightclaw", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -1.0F, -3.0F));
		ModelPartData cube_r1 = rightclaw.addChild("cube_r1", ModelPartBuilder.create().uv(1, 13).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		ModelPartData cube_r2 = rightclaw.addChild("cube_r2", ModelPartBuilder.create().uv(0, 12).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.crabby.traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
	}

	public void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0f, 45.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.crabby.yaw = headYaw * 0.017453292f;
		this.crabby.pitch = headPitch * 0.017453292f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		crabby.render(matrices, vertexConsumer, light, overlay, color);
	}
}