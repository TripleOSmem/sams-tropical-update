package net.sam.tropicalupdate.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.SamsTropicalUpdate;
import net.sam.tropicalupdate.entity.custom.CrabEntity;

public class CrabRenderer extends MobEntityRenderer<CrabEntity, CrabModel<CrabEntity>> {
    private static Identifier TEXTURE = Identifier.of(SamsTropicalUpdate.MOD_ID, "textures/entity/crabby.png");
    public CrabRenderer(EntityRendererFactory.Context context) {
        super(context, new CrabModel(context.getPart(ModModelLayers.CRAB)), 0.3f);
    }

    @Override
    public Identifier getTexture(CrabEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CrabEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()){
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
