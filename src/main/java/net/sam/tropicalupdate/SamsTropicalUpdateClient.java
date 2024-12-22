package net.sam.tropicalupdate;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.sam.tropicalupdate.block.ModBlocks;
import net.sam.tropicalupdate.entity.ModEntities;
import net.sam.tropicalupdate.entity.client.*;
import net.sam.tropicalupdate.particle.custom.FireflyParticle;

public class SamsTropicalUpdateClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRAB, CrabModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOTHER_FIREFLY, MotherFireflyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MOTHER_FIREFLY_ENTITY, MotherFireflyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIREFLY, FireflyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FIREFLY, FireflyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RIVER_DOLPHIN, RiverDolphinEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RIVER_DOLPHIN, RiverDolphinEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LOW_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REINA_DEL_NOCHE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOWERING_LILYPAD, RenderLayer.getCutout());
        ModBlocks.registerColorProviders();

        ParticleFactoryRegistry.getInstance().register(SamsTropicalUpdate.FIREFLY_PARTICLE, FireflyParticle.FireflyFactory::new);

    }


}
