package net.journey.entity.mob.frozen;

import net.journey.entity.MobStats;
import net.journey.entity.base.EntityAttributesHelper;
import net.journey.entity.base.JEntityMob;
import net.journey.init.JourneyLootTables;
import net.journey.init.JourneySounds;
import net.journey.util.PotionEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityFrozenTroll extends JEntityMob {

    public EntityFrozenTroll(World par1World) {
        super(par1World);
        addMeleeAttackingAI();
        this.setSize(0.5F, 1.2F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        EntityAttributesHelper.setMaxHealth(this, MobStats.FROZEN_TROLL_HEALTH);
        EntityAttributesHelper.setAttackDamage(this, MobStats.FROZEN_TROLL_DAMAGE);
        EntityAttributesHelper.setKnockbackResistance(this, MobStats.FROZEN_TROLL_KNOCKBACK_RESISTANCE);
    }

    @Override
    public boolean attackEntityAsMob(Entity e) {
        boolean attacked = super.attackEntityAsMob(e);
        if (attacked) {
            if (e instanceof EntityLivingBase)
                ((EntityLivingBase) e).addPotionEffect(new PotionEffect(PotionEffects.setPotionEffect(PotionEffects.moveSlow, 100, 2)));
            e.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F)) * 2, 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F)) * 2);
        }
        return attacked;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return JourneySounds.SMALL_HONGO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return JourneySounds.SMALL_HONGO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return JourneySounds.SMALL_HONGO_HURT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 60.0D && super.getCanSpawnHere();
    }

    @Override
    public ResourceLocation getLootTable() {
        return JourneyLootTables.FROZEN_TROLL;
    }
}