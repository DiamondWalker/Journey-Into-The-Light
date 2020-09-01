package net.journey.entity.mob.senterian.mob;

import net.journey.entity.base.EntityAttributesHelper;
import net.journey.entity.base.JEntityMob;
import net.journey.init.JourneyLootTables;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySentryStalker extends JEntityMob {

    public EntitySentryStalker(World par1World) {
        super(par1World);
        this.setSize(1.0F, 2.5F);
        addMeleeAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        EntityAttributesHelper.setMaxHealth(this, 75);
        EntityAttributesHelper.setAttackDamage(this, 18);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 20.0D && /**this.posY <  && */super.getCanSpawnHere();
    }

	@Override
	public ResourceLocation getLootTable() {
		return JourneyLootTables.SENTRY_STALKER;
	}
}