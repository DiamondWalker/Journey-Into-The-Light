/*
TODO:

CUSTOM PROJECTILES: A GRAVITY-AFFECTED GRENADE THAT CAUSES SMALL EXPLOSIONS FOR THE GENERIC RANGED ATTACK AND INVISIBLE FLAME PARTICLE PROJECTILES FOR THE FLAMETHROWER
*/
package net.journey.entity.mob.boss;

import net.journey.entity.base.EntityAttributesHelper;
import net.journey.entity.projectile.EntityMagmaFireball;
import net.journey.entity.projectile.EntitySentryKingGrenade;
import net.journey.entity.util.EntityBossCrystal;
import net.journey.init.JourneyLootTables;
import net.journey.init.JourneySounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;
import org.jetbrains.annotations.Nullable;

public class EntitySentryKing extends EntityEssenceBoss implements IRangedAttackMob {

    public int phase;
    private float speedMod;
    private int flamethrowerTimer;

    public EntitySentryKing(World par1World) {
        super(par1World);
        this.moveHelper = new EntitySentryKing.MoveHelper();
        setSize(5.0F, 12F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(7, new EntitySentryKing.AILookAround());
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 1.0D, 1, 20.0F));
        addMeleeAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        EntityAttributesHelper.setMaxHealth(this, 2500);
        EntityAttributesHelper.setAttackDamage(this, 20);
        EntityAttributesHelper.setKnockbackResistance(this, 1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return SoundEvents.ENTITY_WITHER_HURT;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f1) {
    	if (--flamethrowerTimer > 0) {
            this.world.playBroadcastSound(1014, new BlockPos(this), 0);
            double d3 = this.posX;
            double d4 = this.posY;
            double d5 = this.posZ;
            double d6 = target.posX - d3;
            double d7 = target.posY + target.getEyeHeight() - d4;
            double d8 = target.posZ - d5;
            EntityMagmaFireball entitydeathskull = new EntityMagmaFireball(this.world, this, d6, d7, d8);
            entitydeathskull.posY = d4;
            entitydeathskull.posX = d3;
            entitydeathskull.posZ = d5;
            this.world.spawnEntity(entitydeathskull);
        } else if (rand.nextInt(500 / phase) == 1) {
            flamethrowerTimer = 20 * phase;
        } else if (rand.nextInt(100 / phase) == 1) {
            EntitySentryKingGrenade b = new EntitySentryKingGrenade(this.world, this);
            double d0 = target.posX - this.posX;
            double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - b.posY;
            double d2 = target.posZ - this.posZ;
            double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
            b.shoot(d0, d1 + d3 - 5F, d2, 0.6F, (float) (14 - this.world.getDifficulty().getId() * 4));
            JourneySounds.playSound(JourneySounds.MAGIC_SPARKLE, this);
            this.world.spawnEntity(b);
        }
    }

    public void onLivingUpdate() {
        if (this.getHealth() / this.getMaxHealth() >= 0.9) {
            phase = 1;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.8) {
            phase = 2;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.7) {
            phase = 3;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.6) {
            phase = 4;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.5) {
            phase = 5;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.4) {
            phase = 6;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.3) {
            phase = 7;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.2) {
            phase = 8;
        } else if (this.getHealth() / this.getMaxHealth() >= 0.1) {
            phase = 9;
        } else if (this.getHealth() / this.getMaxHealth() >= 0) {
            phase = 10;
        }
        speedMod = (float)0.0625 * phase;
        if (this.getAttackTarget() != null) {
            EntityLivingBase target = this.getAttackTarget();
            this.motionX = (target.posX - this.posX) * (speedMod);
            this.motionY = (target.posY - this.posY + 7.5) * (speedMod);
            this.motionZ = (target.posZ - this.posZ) * (speedMod);
        }
        else if (this.motionY < -0.1) {
        	this.motionY = -0.1;
        }
        super.onLivingUpdate();
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(15) == 0 && super.getCanSpawnHere()
                && this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected @Nullable EntityBossCrystal.Type getDeathCrystalType() {
        return EntityBossCrystal.Type.CORBA;
    }

    @Override
    protected @Nullable ResourceLocation getLootTable() {
        return JourneyLootTables.SENTRY_KING;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    private class MoveHelper extends EntityMoveHelper {
        private final EntitySentryKing e = EntitySentryKing.this;
        private int height;

        public MoveHelper() {
            super(EntitySentryKing.this);
        }

        @Override
        public void onUpdateMoveHelper() {
            if (this.action == Action.MOVE_TO) {
                double d0 = this.posX - this.e.posX;
                double d1 = this.posY - this.e.posY;
                double d2 = this.posZ - this.e.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if (this.height-- <= 0) {
                    this.height += this.e.getRNG().nextInt(5) + 2;
                    d3 = MathHelper.sqrt(d3);
                    if (this.canMove(this.posX, this.posY, this.posZ, d3)) {
                        this.e.motionX += d0 / d3 * 0.1D;
                        this.e.motionY += d1 / d3 * 0.1D;
                        this.e.motionZ += d2 / d3 * 0.1D;
                    } else {
                        this.action = Action.WAIT;
                    }
                }
            }
        }

        private boolean canMove(double x, double y, double z, double h) {
            double d4 = (x - this.e.posX) / h;
            double d5 = (y - this.e.posY) / h;
            double d6 = (z - this.e.posZ) / h;
            AxisAlignedBB axisalignedbb = this.e.getEntityBoundingBox();
            for (int i = 1; i < h; ++i) {
                axisalignedbb = axisalignedbb.offset(d4, d5, d6);
                if (!this.e.world.getCollisionBoxes(this.e, axisalignedbb).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }

    public class AILookAround extends EntityAIBase {
        private final EntitySentryKing e = EntitySentryKing.this;

        public AILookAround() {
            this.setMutexBits(2);
        }

        @Override
        public boolean shouldExecute() {
            return true;
        }

        @Override
        public void updateTask() {
            if (this.e.getAttackTarget() == null) {
                this.e.renderYawOffset = this.e.rotationYaw = -((float) Math.atan2(this.e.motionX, this.e.motionZ))
                        * 180.0F / (float) Math.PI;
            } else {
                EntityLivingBase entitylivingbase = this.e.getAttackTarget();
                double d0 = 64.0D;

                if (entitylivingbase.getDistanceSq(this.e) < d0 * d0) {
                    double d1 = entitylivingbase.posX - this.e.posX;
                    double d2 = entitylivingbase.posZ - this.e.posZ;
                    this.e.renderYawOffset = this.e.rotationYaw = -((float) Math.atan2(d1, d2)) * 180.0F
                            / (float) Math.PI;
                }
            }
        }
    }
}
