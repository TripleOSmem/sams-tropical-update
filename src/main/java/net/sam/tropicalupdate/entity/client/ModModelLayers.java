package net.sam.tropicalupdate.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.SamsTropicalUpdate;

public class ModModelLayers {
    public static final EntityModelLayer CRAB = new EntityModelLayer(
            Identifier.of(SamsTropicalUpdate.MOD_ID, "crabby"), "main"
    );
    public static final EntityModelLayer MOTHER_FIREFLY = new EntityModelLayer(
            Identifier.of(SamsTropicalUpdate.MOD_ID, "mother_firefly_entity"), "main"
    );
    public static final EntityModelLayer FIREFLY = new EntityModelLayer(
            Identifier.of(SamsTropicalUpdate.MOD_ID, "firefly"), "main"
    );
    public static final EntityModelLayer RIVER_DOLPHIN = new EntityModelLayer(
            Identifier.of(SamsTropicalUpdate.MOD_ID, "river_dolphin"), "main"
    );
}
