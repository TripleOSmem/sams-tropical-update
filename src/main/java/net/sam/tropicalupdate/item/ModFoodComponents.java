package net.sam.tropicalupdate.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModFoodComponents {
    public static final FoodComponent RAW_CRAB_FOOD = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.2f)
            .build();
    public static final FoodComponent COOKED_CRAB_FOOD = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(6.0f)
            .build();
    public static final FoodComponent FIREFLY_BOTTLE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600, 0), 1.0f)
            .alwaysEdible()
            .usingConvertsTo(Registries.ITEM.get(Identifier.of("glass_bottle")))
            .build();
}
