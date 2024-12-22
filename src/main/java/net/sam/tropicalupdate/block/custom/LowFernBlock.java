package net.sam.tropicalupdate.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.GrassColors;

import static net.minecraft.block.enums.BlockFace.CEILING;

public class LowFernBlock extends Block {
    public static final MapCodec<ShortPlantBlock> CODEC = createCodec(ShortPlantBlock::new);
    protected static final float field_31261 = 6.0F;
    protected static final VoxelShape GROUND_SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0);
    protected static final VoxelShape CEILING_SHAPE = Block.createCuboidShape(2.0, 11.0, 2.0, 14.0, 16.0, 14.0);

    public static final BooleanProperty CEILING = BooleanProperty.of("ceiling");

    @Override
    public MapCodec<ShortPlantBlock> getCodec() {
        return CODEC;
    }

    public LowFernBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(CEILING, false));
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockPos ceilingPos = pos.up();

        boolean canPlaceOnFloor = this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
        boolean canPlaceOnCeiling = isCeilingValid(world.getBlockState(ceilingPos), world, ceilingPos);
        return canPlaceOnFloor || canPlaceOnCeiling;
    }
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND);
    }
    protected boolean isCeilingValid(BlockState ceiling, WorldView world, BlockPos pos) {
        return ceiling.isIn(BlockTags.LEAVES) || Block.sideCoversSmallSquare(world, pos, Direction.DOWN);
    }


    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        return (!state.canPlaceAt(world, pos) || (direction == Direction.UP && !this.canPlaceAt(state, world, pos)))
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CEILING);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(CEILING, !context.getWorld().getBlockState(context.getBlockPos().down()).isSolid());
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(CEILING) ? CEILING_SHAPE : GROUND_SHAPE;
    }
    @Override
    protected boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }



}
