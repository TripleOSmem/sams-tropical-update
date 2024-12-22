package net.sam.tropicalupdate.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.entity.custom.MotherFireflyEntity;

public class MotherFireflyModel extends EntityModel<MotherFireflyEntity> {
	private final ModelPart base;
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of("tropicalupdate", "mother_firefly_entity"), "main");


	public MotherFireflyModel(ModelPart root) {
		this.base = root.getChild("base");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData root = modelData.getRoot();
		// Create a single box as the model
		root.addChild("base", ModelPartBuilder.create().cuboid(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}

	@Override
	public void setAngles(MotherFireflyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		// No animations, so leave this empty
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		// Render the base part
		base.render(matrixStack, vertexConsumer, light, overlay, color);
	}
}
