package net.sam.tropicalupdate.sound;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.sam.tropicalupdate.SamsTropicalUpdate;

public class ModSounds {

    public static final SoundEvent ENTITY_CRAB_HURT = registerSoundEvent("crab_hurt");
    public static final SoundEvent ENTITY_CRAB_DEATH = registerSoundEvent("crab_death");
    public static final SoundEvent FIREFLY_BOTTLE_CHEWING = registerSoundEvent("chewing_firefly");
    public static final SoundEvent VINES_SNAP = registerSoundEvent("vines_snap");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(SamsTropicalUpdate.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds(){
        SamsTropicalUpdate.LOGGER.info("Registering mod sounds for " + SamsTropicalUpdate.MOD_ID);
    }
}
