package net.sam.tropicalupdate.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import net.sam.tropicalupdate.block.ModBlocks;

public class ModEvents {
    public static void registerEvents() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

            // Get the stack in the current hand
            ItemStack handStack = player.getStackInHand(hand);

            // Ensure the current hand has an axe suitable for the target block
            if (handStack.isIn(ItemTags.AXES)) {


                // Check the offhand stack for a pottery sherd
                ItemStack offHandStack = player.getOffHandStack();
                if (offHandStack.isIn(ItemTags.DECORATED_POT_SHERDS)) {

                    BlockPos blockPos = hitResult.getBlockPos();
                    Block block = world.getBlockState(blockPos).getBlock();

                    // Get the item ID of the pottery sherd
                    String designatedSherdId = Registries.ITEM.getId(offHandStack.getItem()).toString();
                    String[] parts = designatedSherdId.split(":");
                    String sherdType = parts[1].split("_")[0];

                    // Check if the block is a burnable log
                    if (world.getBlockState(blockPos).isIn(BlockTags.LOGS_THAT_BURN)) {

                        if (!world.isClient) {
                            // Replace the log with your tiki totem block
                            Identifier tikiBlockId = Identifier.of("tropicalupdate", (sherdType + "_tiki"));
                            Block tikiBlock = Registries.BLOCK.get(tikiBlockId);

                            if (tikiBlock != null) {
                                world.setBlockState(blockPos, tikiBlock.getDefaultState());

                                // Play sound and consume the pottery sherd
                                ((ServerWorld) world).playSound(null, blockPos, SoundEvents.ITEM_AXE_STRIP,
                                        SoundCategory.BLOCKS, 1.0F, 1.0F);

                                if (!player.getAbilities().creativeMode) {
                                    offHandStack.decrement(1);
                                }

                            }
                        }
                        return ActionResult.SUCCESS;
                    }
                }
            }
            return ActionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() instanceof LilyPadBlock && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
                if (!world.isClient) {
                    world.setBlockState(pos, ModBlocks.FLOWERING_LILYPAD.getDefaultState()); // Change block
                    if (!player.isCreative()) {
                        player.getStackInHand(hand).decrement(1);
                    }
                }
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }
}
