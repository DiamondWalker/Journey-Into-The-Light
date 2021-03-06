package net.journey.dimension.euca.gen.trees;

import net.journey.init.blocks.JourneyBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

import java.util.Random;

public class WorldGenEucaSilverTree extends WorldGenAbstractTree {

    public WorldGenEucaSilverTree(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int i = pos.getX(), j = pos.getY(), k = pos.getZ();
        IBlockState leaves = JourneyBlocks.eucaSilverLeaves.getDefaultState(), log = WorldGenAPI.getEucaLog().getDefaultState();
        int height = 6 + rand.nextInt(5);
        for (int y = 0; y < height; y++) {
            this.setBlockAndNotifyAdequately(world, new BlockPos(i, y + j, k), log);
        }

        j += height;
        int x = i - 4, y1 = j - 8, z = k - 4;
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 0, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 0, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 0, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 0, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 0, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 5, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 5, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 5, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 6, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 6, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 6, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 6, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 7, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 7, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 8, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 8, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 8, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 8, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 9, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 9, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 1, y1 + 9, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 4, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 4, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 4, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 5, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 5, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 5, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 5, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 5, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 6, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 6, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 6, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 6, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 6, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 6, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 7, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 7, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 7, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 7, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 8, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 8, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 8, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 8, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 8, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 8, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 9, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 9, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 9, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 9, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 9, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 10, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 10, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 2, y1 + 10, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 3, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 4, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 4, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 4, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 4, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 4, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 5, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 5, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 5, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 5, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 5, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 5, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 5, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 6, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 6, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 6, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 6, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 6, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 6, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 0), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 7, z + 8), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 8, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 8, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 8, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 8, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 8, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 8, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 9, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 9, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 9, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 9, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 9, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 9, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 9, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 10, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 10, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 10, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 10, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 10, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 3, y1 + 11, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 3, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 3, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 4, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 4, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 4, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 4, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 5, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 5, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 5, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 5, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 5, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 5, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 0), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 6, z + 8), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 0), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 7, z + 8), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 0), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 8, z + 8), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 9, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 9, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 9, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 9, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 9, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 9, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 9, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 10, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 10, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 10, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 10, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 10, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 11, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 11, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 4, y1 + 11, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 3, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 4, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 4, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 4, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 4, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 4, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 5, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 5, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 5, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 5, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 5, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 5, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 5, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 6, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 6, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 6, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 6, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 6, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 6, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 0), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 7, z + 8), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 8, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 8, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 8, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 8, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 8, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 8, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 9, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 9, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 9, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 9, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 9, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 9, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 9, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 10, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 10, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 10, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 10, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 10, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 5, y1 + 11, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 4, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 4, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 4, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 5, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 5, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 5, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 5, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 5, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 6, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 6, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 6, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 6, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 6, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 6, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 7, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 7, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 7, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 7, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 8, z + 1), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 8, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 8, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 8, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 8, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 8, z + 7), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 9, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 9, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 9, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 9, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 9, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 10, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 10, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 6, y1 + 10, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 5, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 5, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 5, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 6, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 6, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 6, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 6, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 7, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 7, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 8, z + 2), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 8, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 8, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 8, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 8, z + 6), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 9, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 9, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 7, y1 + 9, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 8, y1 + 6, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 8, y1 + 7, z + 3), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 8, y1 + 7, z + 4), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 8, y1 + 7, z + 5), leaves);
        this.setBlockAndNotifyAdequately(world, new BlockPos(x + 8, y1 + 8, z + 4), leaves);

        return true;
    }
}