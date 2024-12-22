package net.sam.tropicalupdate.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class JungleRiverFeature extends Feature<DefaultFeatureConfig> {
    public JungleRiverFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos origin = context.getOrigin();
        World world = (World) context.getWorld();
        Random random = context.getRandom();

        // Define the width and depth of the river
        int width = random.nextInt(3) + 1;  // Random width between 1-3
        int depth = random.nextInt(2) + 1;  // Random depth between 1-2

        // Carve a path (river) by replacing blocks with water
        for (int dx = -width; dx <= width; dx++) {
            for (int dz = -width; dz <= width; dz++) {
                BlockPos riverPos = origin.add(dx, 0, dz);

                // Replace ground with water or air, depending on the depth
                for (int dy = 0; dy < depth; dy++) {
                    BlockPos blockPos = riverPos.add(0, -dy, 0);
                    if (!world.getBlockState(blockPos).isAir()) {
                        world.setBlockState(blockPos, Blocks.WATER.getDefaultState(), 2);
                    }
                }
            }
        }

        return true;
    }
}


