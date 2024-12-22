package net.sam.tropicalupdate.block;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.SamsTropicalUpdate;
import net.sam.tropicalupdate.block.custom.LowFernBlock;
import net.sam.tropicalupdate.block.custom.ModStairs;
import net.sam.tropicalupdate.block.custom.TikiBlock;

public class ModBlocks {
    public static final Block THATCHES = registerBlock("thatches",
            new Block(AbstractBlock.Settings
                    .create()
                    .hardness(0.5f)
                    .resistance(0.5f)
                    .sounds(BlockSoundGroup.GRASS)
                    .burnable()
                    .mapColor(MapColor.YELLOW)

            ));
    public static final Block THATCH_SLAB = registerBlock("thatch_slab",
            new SlabBlock(AbstractBlock.Settings
                    .create()
                    .hardness(0.5f)
                    .resistance(0.5f)
                    .sounds(BlockSoundGroup.GRASS)
                    .burnable()
                    .mapColor(MapColor.YELLOW)
            ));
    public static final Block SHELL_BLOCK = registerBlock("shell_block",
            new Block(AbstractBlock.Settings
                    .create()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .sounds(BlockSoundGroup.BONE)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresTool()
            ));
    public static final Block CHISELED_SHELL_BLOCK = registerBlock("chiseled_shell_block",
            new Block(AbstractBlock.Settings
                    .create()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .sounds(BlockSoundGroup.BONE)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresTool()
            ));
    public static final Block CHISELED_SHELL_BRICKS = registerBlock("chiseled_shell_bricks",
            new Block(AbstractBlock.Settings
                    .create()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .sounds(BlockSoundGroup.BONE)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresTool()
            ));
    public static final Block SHELL_BRICKS = registerBlock("shell_bricks",
            new Block(AbstractBlock.Settings
                    .create()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .sounds(BlockSoundGroup.BONE)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresTool()
            ));
    public static final Block SHELL_BRICK_SLAB = registerBlock("shell_brick_slab",
            new SlabBlock(AbstractBlock.Settings
                    .create()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .sounds(BlockSoundGroup.BONE)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresTool()
            ));
    public static final Block SHELL_BRICK_STAIRS = registerBlock("shell_brick_stairs",
            new ModStairs(ModBlocks.SHELL_BRICKS.getDefaultState(),AbstractBlock.Settings
                    .create()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .sounds(BlockSoundGroup.BONE)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresTool()
            ));
    public static final Block THATCH_STAIRS = registerBlock("thatch_stairs",
            new ModStairs(ModBlocks.THATCHES.getDefaultState(),AbstractBlock.Settings
                    .create()
                    .hardness(0.5f)
                    .resistance(0.5f)
                    .sounds(BlockSoundGroup.GRASS)
                    .burnable()
                    .mapColor(MapColor.YELLOW)
            ));
    public static final Block SHELL_LANTERN = registerBlock("shell_lantern",
            new Block(AbstractBlock.Settings
                    .create()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .sounds(BlockSoundGroup.BONE)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresTool()
                    .luminance(state -> 15)
            ));
    public static final Block SHELLY_SAND = registerBlock("shelly_sand",
            new ColoredFallingBlock(
                    new ColorCode(14406560),
                    AbstractBlock.Settings
                            .create()
                            .mapColor(MapColor.PALE_YELLOW)
                            .instrument(NoteBlockInstrument.SNARE)
                            .strength(0.5f)
                            .resistance(0.5f)
                            .sounds(BlockSoundGroup.SAND)
                            .requiresTool()
            )
    );

    public static final TikiBlock ANGLER_TIKI = (TikiBlock) registerBlock("angler_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "angler"
            ));
    public static final TikiBlock ARCHER_TIKI = (TikiBlock) registerBlock("archer_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "archer"
            ));
    public static final TikiBlock ARMS_UP_TIKI = (TikiBlock) registerBlock("arms_up_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "arms_up_tiki"
            ));
    public static final TikiBlock BLADE_TIKI = (TikiBlock) registerBlock("blade_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "angler"
            ));
    public static final TikiBlock BREWER_TIKI = (TikiBlock) registerBlock("brewer_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "brewer"
            ));
    public static final TikiBlock BURN_TIKI = (TikiBlock) registerBlock("burn_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "burn"
            ));
    public static final TikiBlock DANGER_TIKI = (TikiBlock) registerBlock("danger_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "danger"
            ));
    public static final TikiBlock EXPLORER_TIKI = (TikiBlock) registerBlock("explorer_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "explorer"
            ));
    public static final TikiBlock FRIEND_TIKI = (TikiBlock) registerBlock("friend_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "friend"
            ));
    public static final TikiBlock HEART_TIKI = (TikiBlock) registerBlock("heart_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "heart"
            ));
    public static final TikiBlock HEARTBREAK_TIKI = (TikiBlock) registerBlock("heartbreak_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "heartbreak"
            ));
    public static final TikiBlock HOWL_TIKI = (TikiBlock) registerBlock("howl_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "howl"
            ));
    public static final TikiBlock MINER_TIKI = (TikiBlock) registerBlock("miner_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "miner"
            ));
    public static final TikiBlock MOURNER_TIKI = (TikiBlock) registerBlock("mourner_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "mourner"
            ));
    public static final TikiBlock PLENTY_TIKI = (TikiBlock) registerBlock("plenty_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "plenty"
            ));
    public static final TikiBlock PRIZE_TIKI = (TikiBlock) registerBlock("prize_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "prize"
            ));
    public static final TikiBlock SHEAF_TIKI = (TikiBlock) registerBlock("sheaf_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "sheaf"
            ));
    public static final TikiBlock SHELTER_TIKI = (TikiBlock) registerBlock("shelter_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "shelter"
            ));
    public static final TikiBlock SKULL_TIKI = (TikiBlock) registerBlock("skull_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "skull"
            ));
    public static final TikiBlock SNORT_TIKI = (TikiBlock) registerBlock("snort_tiki",
            new TikiBlock(AbstractBlock.Settings
                    .create()
                    .resistance(3f)
                    .hardness(2f)
                    .requiresTool()
                    .nonOpaque(),
                    "snort"
            ));
    public static final LowFernBlock LOW_FERN = (LowFernBlock) registerBlock(
            "low_fern",
            new LowFernBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .breakInstantly()
                            .noCollision()
                            .sounds(BlockSoundGroup.SPORE_BLOSSOM)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    public static final LowFernBlock REINA_DEL_NOCHE = (LowFernBlock) registerBlock(
            "reina_del_noche",
            new LowFernBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .breakInstantly()
                            .noCollision()
                            .sounds(BlockSoundGroup.SPORE_BLOSSOM)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    public static final LilyPadBlock FLOWERING_LILYPAD = (LilyPadBlock) registerBlock(
            "flowering_lilypad",
            new LilyPadBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .breakInstantly()
                            .nonOpaque()
                            .sounds(BlockSoundGroup.LILY_PAD)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static void registerColorProviders() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                // Use biome foliage color
                return BiomeColors.getFoliageColor(world, pos);
            }
            return -1;
        },
                LOW_FERN,
                FLOWERING_LILYPAD
        );
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SamsTropicalUpdate.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(SamsTropicalUpdate.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        SamsTropicalUpdate.LOGGER.info("Registering blocks for " + SamsTropicalUpdate.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(SHELL_BLOCK);
            entries.add(SHELLY_SAND);

            entries.add(LOW_FERN);
            entries.add(REINA_DEL_NOCHE);
            entries.add(FLOWERING_LILYPAD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(THATCHES);
            entries.add(SHELL_BRICKS);
            entries.add(SHELL_BRICK_SLAB);
            entries.add(SHELL_BRICK_STAIRS);
            entries.add(CHISELED_SHELL_BLOCK);
            entries.add(CHISELED_SHELL_BRICKS);
            entries.add(SHELL_LANTERN);
            entries.add(THATCH_STAIRS);
            entries.add(THATCH_SLAB);

            entries.add(ANGLER_TIKI);
            entries.add(ARCHER_TIKI);
            entries.add(BLADE_TIKI);
            entries.add(BREWER_TIKI);
            entries.add(ARMS_UP_TIKI);
            entries.add(BURN_TIKI);
            entries.add(DANGER_TIKI);
            entries.add(EXPLORER_TIKI);
            entries.add(FRIEND_TIKI);
            entries.add(HEART_TIKI);
            entries.add(HEARTBREAK_TIKI);
            entries.add(HOWL_TIKI);
            entries.add(MINER_TIKI);
            entries.add(MOURNER_TIKI);
            entries.add(PLENTY_TIKI);
            entries.add(PRIZE_TIKI);
            entries.add(SHEAF_TIKI);
            entries.add(SHELTER_TIKI);
            entries.add(SKULL_TIKI);
            entries.add(SNORT_TIKI);
        });
    }
}
