package net.sam.tropicalupdate.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.sam.tropicalupdate.SamsTropicalUpdate;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> JUNGLE_RIVER_FEATURE_KEY = registerKey("jungle_river_feature");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        JungleRiverFeature jungleRiverFeature = new JungleRiverFeature(DefaultFeatureConfig.CODEC);

        register(context, JUNGLE_RIVER_FEATURE_KEY, jungleRiverFeature, FeatureConfig.DEFAULT);

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SamsTropicalUpdate.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
