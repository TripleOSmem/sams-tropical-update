package net.sam.tropicalupdate.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.sam.tropicalupdate.world.ModPlacedFeatures;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.FLUID_SPRINGS,
                ModPlacedFeatures.JUNGLE_RIVER_FEATURE_PLACED_KEY);


    }
}
