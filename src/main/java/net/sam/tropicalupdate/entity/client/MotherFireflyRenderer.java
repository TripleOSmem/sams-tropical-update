package net.sam.tropicalupdate.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.SamsTropicalUpdate;
import net.sam.tropicalupdate.entity.custom.MotherFireflyEntity;

public class MotherFireflyRenderer extends MobEntityRenderer<MotherFireflyEntity, MotherFireflyModel> {

    public MotherFireflyRenderer(EntityRendererFactory.Context context) {
        super(context, new MotherFireflyModel(context.getPart(MotherFireflyModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public boolean shouldRender(MotherFireflyEntity entity, net.minecraft.client.render.Frustum frustum, double x, double y, double z) {
        return false; // Prevents the entity from rendering.
    }

    @Override
    public Identifier getTexture(MotherFireflyEntity entity) {
        return Identifier.of(SamsTropicalUpdate.MOD_ID, "textures/entity/mother_firefly_entity.png"); // Texture path just in case
    }
}
