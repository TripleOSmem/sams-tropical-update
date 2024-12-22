package net.sam.tropicalupdate.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> BLINDNESS = register("blindness", new Potion(new StatusEffectInstance(StatusEffects.BLINDNESS, 3000)));
    public static final RegistryEntry<Potion> LONG_BLINDNESS = register(
            "long_blindness", new Potion("blindness", new StatusEffectInstance(StatusEffects.BLINDNESS, 6000))
    );
    public static final RegistryEntry<Potion> STRONG_BLINDNESS = register(
            "strong_blindness", new Potion("blindness", new StatusEffectInstance(StatusEffects.BLINDNESS, 3000, 1))
    );


    public static void registerPotions(){}

    private static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.ofVanilla(name), potion);
    }

    public static void registerPotionsRecipes(){}
}