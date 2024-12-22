package net.sam.tropicalupdate.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.sam.tropicalupdate.sound.ModSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    private boolean wasSprintingKeyPressedLastTick = false;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;
        MinecraftClient client = MinecraftClient.getInstance();

        KeyBinding sprintKey = client.options.sprintKey;
        boolean isSprintKeyPressed = sprintKey.wasPressed();
        if (isSprintKeyPressed && !wasSprintingKeyPressedLastTick && isTouchingVines(player) && !player.hasStatusEffect(StatusEffects.LEVITATION)) {
            swingFromVines(player);
        }

        wasSprintingKeyPressedLastTick = isSprintKeyPressed;
    }

    private boolean isTouchingVines(PlayerEntity player) {
        BlockPos pos = player.getBlockPos();
        BlockState state = player.getWorld().getBlockState(pos);
        boolean isVines = state.isOf(Blocks.VINE);
        if (isVines){
            player.getWorld().breakBlock(pos, false, player);
        }
        return isVines;
    }

    private void swingFromVines(PlayerEntity player) {
        Vec3d lookDirection = player.getRotationVec(1.0F);

        double launchPower = 1.0;
        Vec3d launchVelocity = new Vec3d(lookDirection.x * launchPower * 0.7, Math.max(lookDirection.y, 0.5) * launchPower, lookDirection.z * launchPower * 0.7);

        // Apply velocity to the player
        player.addVelocity(launchVelocity.x, launchVelocity.y, launchVelocity.z);
        player.velocityModified = true;
        player.getWorld().playSound(null, player.getBlockPos(), ModSounds.VINES_SNAP, SoundCategory.PLAYERS, 1.0F, 1.0F);

    }

}

