package net.sam.tropicalupdate.entity;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.entity.custom.CrabEntity;
import net.sam.tropicalupdate.entity.custom.FireflyEntity;
import net.sam.tropicalupdate.entity.custom.MotherFireflyEntity;

public class ModEntities implements ModInitializer {
    public static final EntityType<CrabEntity> CRAB = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("tropicalupdate", "crabby"),
            EntityType.Builder.create(CrabEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.4f).build("crabby")
    );
    public static final EntityType<MotherFireflyEntity> MOTHER_FIREFLY_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("tropicalupdate", "mother_firefly_entity"),
            EntityType.Builder.create(MotherFireflyEntity::new, SpawnGroup.CREATURE).dimensions(0f, 0f).build("mother_firefly_entity")
    );
    public static final EntityType<FireflyEntity> FIREFLY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("tropicalupdate", "firefly"),
            EntityType.Builder.create(FireflyEntity::new, SpawnGroup.AMBIENT).dimensions(0.25f, 0.25f).build("firefly")
    );
    public static final EntityType<DolphinEntity> RIVER_DOLPHIN = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("tropicalupdate", "river_dolphin"),
            EntityType.Builder.create(DolphinEntity::new, SpawnGroup.WATER_CREATURE).dimensions(0.9F, 0.6F).eyeHeight(0.3F).build("river_dolphin")
    );

    @Override
    public void onInitialize() {

    }
}
