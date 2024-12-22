package net.sam.tropicalupdate.entity.custom;

import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.sam.tropicalupdate.item.ModItems;
import net.sam.tropicalupdate.item.custom.FireflyBottleItem;

public class FireflyEntity extends MobEntity {
    // Constructor

    public FireflyEntity(EntityType<FireflyEntity> entityType, World world) {
        super(entityType, world);
        this.noClip = true;

    }

    public static DefaultAttributeContainer.Builder createFireflyAttributes() {
        return MobEntity.createMobAttributes();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            double hoverSpeed = 0.05;
            double hoverHeight = 0.01;

            double hoverOffset = Math.sin(this.age * hoverSpeed) * hoverHeight;

            this.setPos(this.getX() - 0.5 * hoverOffset, this.getY() + hoverOffset, this.getZ() + hoverOffset * 0.5);
        }

        if (this.age > 1200) {
            this.discard();
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand){
        ItemStack heldItem = player.getStackInHand(hand);
        if (heldItem.getItem() == Items.GLASS_BOTTLE) {
            if (!this.getWorld().isClient) {
                if (!player.getAbilities().creativeMode) {
                    heldItem.decrement(1);
                    player.giveItemStack(new ItemStack((ItemConvertible) ModItems.FIREFLY_BOTTLE));
                }
                this.playSound(SoundEvents.ITEM_BOTTLE_FILL, 1.0f, 1.0f);
                this.discard();
            }
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }


    @Override
    public boolean damage(DamageSource source, float amount) {return false;}

    @Override
    public PistonBehavior getPistonBehavior() {
        return PistonBehavior.IGNORE;
    }

    @Override
    public boolean isCollidable() {return false;}

    @Override
    public boolean hasNoGravity() {return true;}

}
