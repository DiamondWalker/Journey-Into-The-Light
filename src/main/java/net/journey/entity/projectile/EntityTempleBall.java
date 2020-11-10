package net.journey.entity.projectile;

import net.journey.JITL;
import net.journey.enums.EnumParticlesClasses;
import net.journey.util.PotionEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class EntityTempleBall extends EntityDamagingProjectile {

	public EntityTempleBall(World var1) {
		super(var1);
	}

	public EntityTempleBall(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3, dam);
	}

	@Override
    public void onUpdate() {
        Random rand = new Random();
        super.onUpdate();
        for (int i = 0; i < 20; ++i) {
            JITL.proxy.spawnParticle(EnumParticlesClasses.GREENPACE, this.world, this.posX, this.posY - 1.0F, this.posZ, false);
        }
    }

	@Override
	protected void onImpact(@NotNull RayTraceResult rayTraceResult) {
		if (rayTraceResult.entityHit instanceof EntityLivingBase) {
			rayTraceResult.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), getDamage());
			((EntityLivingBase) rayTraceResult.entityHit).addPotionEffect(new PotionEffect(PotionEffects.getPotionFromID(PotionEffects.moveSlow), 100, 2));
			((EntityLivingBase) rayTraceResult.entityHit).addPotionEffect(new PotionEffect(PotionEffects.getPotionFromID(PotionEffects.confusion), 100, 5));
			((EntityLivingBase) rayTraceResult.entityHit).addPotionEffect(new PotionEffect(PotionEffects.getPotionFromID(PotionEffects.digSlow), 100, 2));
		}
		if (!world.isRemote) this.setDead();
	}

    @Override
    protected float getGravityVelocity() {
        return 0.032F;
    }
}