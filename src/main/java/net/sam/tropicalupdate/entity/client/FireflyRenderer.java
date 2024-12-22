package net.sam.tropicalupdate.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.SamsTropicalUpdate;
import net.sam.tropicalupdate.entity.custom.FireflyEntity;

public class FireflyRenderer extends MobEntityRenderer<FireflyEntity, FireflyModel<FireflyEntity>> {
    private static Identifier TEXTURE = Identifier.of(SamsTropicalUpdate.MOD_ID, "textures/entity/firefly.png");
    public FireflyRenderer(EntityRendererFactory.Context context) {
        super(context, new FireflyModel(context.getPart(ModModelLayers.FIREFLY)), 1.0f);
    }

    @Override
    public Identifier getTexture(FireflyEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FireflyEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1.2f, 1.2f, 1.2f);
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    protected float getShadowRadius(FireflyEntity entity) {return 0.0f;}

}
