package net.sam.tropicalupdate.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.DolphinEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.DolphinHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.DolphinEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RiverDolphinEntityRenderer extends DolphinEntityRenderer {
    private static final Identifier RIVER_DOLPHIN_TEXTURE = Identifier.of("tropicalupdate", "textures/entity/river_dolphin.png");

    public RiverDolphinEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addFeature(new DolphinHeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(DolphinEntity entity) {
        return RIVER_DOLPHIN_TEXTURE;
    }
}


