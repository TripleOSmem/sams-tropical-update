package net.sam.tropicalupdate.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.heightprovider.VeryBiasedToBottomHeightProvider;
import net.minecraft.world.gen.placementmodifier.*;
import net.sam.tropicalupdate.SamsTropicalUpdate;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> JUNGLE_RIVER_FEATURE_PLACED_KEY = registerKey("jungle_river_feature_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // Placement modifiers for Jungle River
        List<PlacementModifier> jungleRiverModifiers = List.of(
                CountPlacementModifier.of(20),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.of(VeryBiasedToBottomHeightProvider.create(
                        YOffset.getBottom(), YOffset.belowTop(8), 8)),
                BiomePlacementModifier.of()
        );

        // Register the placed feature with the modifiers
        register(context, JUNGLE_RIVER_FEATURE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.JUNGLE_RIVER_FEATURE_KEY),
                jungleRiverModifiers);
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SamsTropicalUpdate.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
