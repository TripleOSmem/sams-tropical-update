package net.sam.tropicalupdate.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.sam.tropicalupdate.SamsTropicalUpdate;
import net.sam.tropicalupdate.block.ModBlocks;
import net.sam.tropicalupdate.entity.ModEntities;
import net.sam.tropicalupdate.item.custom.FireflyBottleItem;

import static net.sam.tropicalupdate.item.ModFoodComponents.COOKED_CRAB_FOOD;
import static net.sam.tropicalupdate.item.ModFoodComponents.RAW_CRAB_FOOD;

public class ModItems {

    public static final Item RAW_CRAB_MEAT = registerItem("raw_crab_meat", new Item(new Item.Settings().food(RAW_CRAB_FOOD)));
    public static final Item COOKED_CRAB_MEAT = registerItem("cooked_crab_meat", new Item(new Item.Settings().food(COOKED_CRAB_FOOD)));

    public static final Item CONCH_SHELL = registerItem("conch_shell", new Item(new Item.Settings().rarity(Rarity.RARE)));

    public static final Item CRAB_SPAWN_EGG = registerItem("crab_spawn_egg", new SpawnEggItem(ModEntities.CRAB, 1856755, 12996615, new Item.Settings()));
    public static final Item RIVER_DOLPHIN_SPAWN_EGG = registerItem("river_dolphin_spawn_egg", new SpawnEggItem(ModEntities.RIVER_DOLPHIN, 13871529, 10844280, new Item.Settings()));

    public static final Item FIREFLY_BOTTLE = registerItem("firefly_bottle", new FireflyBottleItem(new Item.Settings().food(ModFoodComponents.FIREFLY_BOTTLE)));

    public static final Item FLOWERING_LILYPAD = registerItem("flowering_lilypad", new PlaceableOnWaterItem(ModBlocks.FLOWERING_LILYPAD, new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(SamsTropicalUpdate.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SamsTropicalUpdate.LOGGER.info("Registering items for " + SamsTropicalUpdate.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(RAW_CRAB_MEAT);
            entries.add(COOKED_CRAB_MEAT);
            entries.add(FIREFLY_BOTTLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CONCH_SHELL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(CRAB_SPAWN_EGG);
            entries.add(RIVER_DOLPHIN_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FIREFLY_BOTTLE);
        });
    }
}
