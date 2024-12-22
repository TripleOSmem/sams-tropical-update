package net.sam.tropicalupdate.mixin;

import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.sam.tropicalupdate.block.ModBlocks;
import net.sam.tropicalupdate.item.ModItems;
import net.sam.tropicalupdate.potion.ModPotions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    @Inject(at = @At("HEAD"), method = "registerDefaults")
    private static void init(BrewingRecipeRegistry.Builder builder, CallbackInfo info) {
        builder.registerRecipes(ModBlocks.REINA_DEL_NOCHE.asItem(), ModPotions.BLINDNESS);
        builder.registerPotionRecipe(ModPotions.BLINDNESS, Items.REDSTONE, ModPotions.LONG_BLINDNESS);
        builder.registerPotionRecipe(ModPotions.BLINDNESS, Items.GLOWSTONE_DUST, ModPotions.STRONG_BLINDNESS);
    }
}

