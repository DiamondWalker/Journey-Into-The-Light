package net.jitl.common.block.portal;

import net.jitl.common.dimension.BaseTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class JBasePortalBlock extends NetherPortalBlock {

    private final RegistryKey<World> dimensionID;
    private final Block frame;

    public JBasePortalBlock(Properties properties, RegistryKey<World> dimID, Block frame) {
        super(properties);
        dimensionID = dimID;
        this.frame = frame;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
       //make particals call in constructor
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof ServerPlayerEntity) {
            if(!entityIn.isPassenger() && !entityIn.isVehicle() && entityIn.canChangeDimensions()) {
                ServerPlayerEntity playerMP = (ServerPlayerEntity)entityIn;
                RegistryKey<World> dimension = worldIn.dimension() == dimensionID ? World.OVERWORLD : dimensionID;
                ServerWorld serverworld = (ServerWorld)playerMP.level.getServer().getLevel(dimension);
                playerMP.changeDimension(serverworld, new BaseTeleporter(serverworld, this, this.frame));//I have a feeling this has to be done in events
            }
        }
    }
}