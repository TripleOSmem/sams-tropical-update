package net.sam.tropicalupdate.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class FireflyParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;
    private final boolean flipHorizontally;
    private static final Random RANDOM = new Random();


    public FireflyParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.velocityMultiplier = 0.96F;
        this.spriteProvider = spriteProvider;
        float f = 2.5F;
        this.velocityX *= 0.1F;
        this.velocityY *= 0.1F;
        this.velocityZ *= 0.1F;
        this.velocityX += velocityX;
        this.velocityY += velocityY;
        this.velocityZ += velocityZ;
        this.flipHorizontally = RANDOM.nextBoolean();
        float g = 1.0F;
        this.red = g;
        this.green = g;
        this.blue = g;
        this.maxAge = 100 + (int)(Math.random() * 50);
        this.collidesWithWorld = false;
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public float getSize(float tickDelta) {
        return this.scale * MathHelper.clamp(((float)this.age + tickDelta) / (float)this.maxAge * 32.0F, 0.0F, 1.0F);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.dead) {
            this.setSpriteForAge(this.spriteProvider);
            PlayerEntity playerEntity = this.world.getClosestPlayer(this.x, this.y, this.z, 2.0, false);
            if (playerEntity != null) {
                double d = playerEntity.getY();
                if (this.y > d) {
                    this.y += (d - this.y) * 0.2;
                    this.velocityY += (playerEntity.getVelocity().y - this.velocityY) * 0.2;
                    this.setPos(this.x, this.y, this.z);
                }
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static class FireflyFactory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public FireflyFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new FireflyParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);
        }
    }

    @Override
    protected float getMinU() {
        return flipHorizontally ? sprite.getMaxU() : sprite.getMinU();
    }

    @Override
    protected float getMaxU() {
        return flipHorizontally ? sprite.getMinU() : sprite.getMaxU();
    }
}
