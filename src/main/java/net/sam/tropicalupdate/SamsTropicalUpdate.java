package net.sam.tropicalupdate;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.block.ModBlocks;
import net.sam.tropicalupdate.entity.ModEntities;
import net.sam.tropicalupdate.entity.custom.CrabEntity;
import net.sam.tropicalupdate.entity.custom.FireflyEntity;
import net.sam.tropicalupdate.entity.custom.MotherFireflyEntity;
import net.sam.tropicalupdate.event.ModEvents;
import net.sam.tropicalupdate.item.ModItems;
import net.sam.tropicalupdate.potion.ModPotions;
import net.sam.tropicalupdate.sound.ModSounds;
import net.sam.tropicalupdate.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamsTropicalUpdate implements ModInitializer {
	public static final String MOD_ID = "tropicalupdate";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final SimpleParticleType FIREFLY_PARTICLE = FabricParticleTypes.simple();

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FabricDefaultAttributeRegistry.register(ModEntities.CRAB, CrabEntity.createCrabAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MOTHER_FIREFLY_ENTITY, MotherFireflyEntity.createMotherFireflyAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FIREFLY, FireflyEntity.createFireflyAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.RIVER_DOLPHIN, DolphinEntity.createDolphinAttributes());
		ModSounds.registerSounds();
		ModEvents.registerEvents();
		ModPotions.registerPotions();

		ModWorldGeneration.generateModWorldGen();


		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(SamsTropicalUpdate.MOD_ID, "firefly_particle"), FIREFLY_PARTICLE);
	}

}