package net.sam.tropicalupdate.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sam.tropicalupdate.entity.ModEntities;
import net.sam.tropicalupdate.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.recipe.Ingredient.*;

public class CrabEntity extends AnimalEntity {
    private boolean isSpinning = false;

    public CrabEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    private void setupAnimationStates(){
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }}

    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick(){
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
        if (this.isSubmergedInWater()) {
            this.setAir(this.getMaxAir()); // Replenish air underwater
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(1, new TemptGoal(this, 1.15D, ofItems(Items.BAMBOO_FENCE_GATE), false));
        this.goalSelector.add(1, new TemptGoal(this, 1.15D, fromTag(ItemTags.CAT_FOOD), false));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class,10f));
        this.goalSelector.add(3, new AvoidSunlightGoal(this));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1.15D));
        this.goalSelector.add(5, new LookAroundGoal(this));

    }

    public static DefaultAttributeContainer.Builder createCrabAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY, 1)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_OXYGEN_BONUS, -2);
    }
    private boolean songPlaying;
    @Nullable
    public BlockPos songSource;

    @Override
    public void setNearbySongPlaying(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
    }

    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    public void tickMovement() {
        if (this.songSource != null && this.songSource.isWithinDistance(this.getPos(), 5)) {
            this.songPlaying = true;
            this.setAngles((getYaw() + 20f), getPitch());
        } else {
            this.songPlaying = false;
            this.songSource = null;
        }
        super.tickMovement();
    }


    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.CRAB.create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack){
        return stack.isIn(ItemTags.CAT_FOOD);
    }


    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.ENTITY_CRAB_DEATH;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_CRAB_HURT;
    }

}
