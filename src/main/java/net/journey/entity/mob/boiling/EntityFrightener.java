package net.journey.entity.mob.boiling;

import net.journey.entity.base.EntityAttributesHelper;
import net.journey.entity.base.JEntityMob;
import net.journey.init.JourneyLootTables;
import net.journey.init.JourneySounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.List;

public class EntityFrightener extends JEntityMob {

    public EntityFrightener(World par1World) {
        super(par1World);
        addMeleeAttackingAI();
        setSize(0.7F, 2.0F);
        isImmuneToFire = true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        EntityAttributesHelper.setMaxHealth(this, 40);
        EntityAttributesHelper.setAttackDamage(this, 9);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return JourneySounds.HONGO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return JourneySounds.HONGO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return JourneySounds.CALCIA_HURT;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.world.isDaytime() && !this.world.isRemote) {
            float var1 = getBrightness();
        }

        List<Entity> e = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
        for (Entity entity : e) {
            if (entity instanceof EntityPlayer && canEntityBeSeen(entity))
                entity.setFire(5 + rand.nextInt(7));
        }
    }

	@Override
	public ResourceLocation getLootTable() {
		return JourneyLootTables.FRIGHTENER;
	}
}