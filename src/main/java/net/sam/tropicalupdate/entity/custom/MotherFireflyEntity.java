package net.sam.tropicalupdate.entity.custom;

import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.sam.tropicalupdate.SamsTropicalUpdate;
import net.sam.tropicalupdate.entity.ModEntities;

public class MotherFireflyEntity extends MobEntity {
    // Constructor

    private int particleSpawnTimer = 0;
    private int entitySpawnTimer = 0;

    public MotherFireflyEntity(EntityType<MotherFireflyEntity> entityType, World world) {
        super(entityType, world);
        this.noClip = true;
    }


    // Override render behavior to make it invisible
    @Override
    public boolean isInvisible() {
        return true;
    }

    public static DefaultAttributeContainer.Builder createMotherFireflyAttributes() {
        return MobEntity.createMobAttributes();
    }


    @Override
    public void tick() {
        super.tick();

        this.setVelocity(0, 0, 0);
        particleSpawnTimer++;
        entitySpawnTimer++;

        if (particleSpawnTimer >= 8 && (getWorld().getTimeOfDay() >= 13100) && (getWorld().getTimeOfDay() <= 22700)) {
            particleSpawnTimer = 0;

            if (!this.getWorld().isClient && this.getWorld() instanceof ServerWorld serverWorld) {
                ParticleEffect particleType = SamsTropicalUpdate.FIREFLY_PARTICLE;

                serverWorld.spawnParticles(
                        particleType,
                        this.getX(), this.getY(), this.getZ(),
                        1,
                        7, 3, 7,
                        0.01
                );
            }

        }
        if (entitySpawnTimer >= 400 && (this.getWorld() instanceof ServerWorld serverWorld) && (getWorld().getTimeOfDay() >= 13100) && (getWorld().getTimeOfDay() <= 22700)) {
            entitySpawnTimer = 0;
            FireflyEntity firefly = new FireflyEntity(ModEntities.FIREFLY, this.getWorld());
            firefly.refreshPositionAndAngles(
                    this.getX() + (random.nextDouble() - 0.5) * 14,
                    this.getY() + (random.nextDouble() - 0.2) * 4,
                    this.getZ() + (random.nextDouble() - 0.5) * 14,
                    random.nextFloat() * 360,
                    0
            );

            serverWorld.spawnEntity(firefly);
        }



    }

    @Override
    public boolean damage(DamageSource source, float amount) {return false;}

    @Override
    public PistonBehavior getPistonBehavior() {
        return PistonBehavior.IGNORE;
    }

    @Override
    public boolean isCollidable() {return false;}
}
