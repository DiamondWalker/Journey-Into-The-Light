package net.journey.dimension.euca.gen.trees;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

import java.util.Random;

public class WorldGenEucaTree extends WorldGenerator {
    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int i = pos.getX() - 4, j = pos.getY() - 8, k = pos.getZ() - 4;
        IBlockState leaves = WorldGenAPI.getEucaLeaves().getDefaultState(), log = WorldGenAPI.getEucaLog().getDefaultState();
        int height = 10 + rand.nextInt(10);
        for (int y = 0; y < height; y++) {
            this.setBlockAndNotifyAdequately(world, new BlockPos(i, y + j, k), log);
        }

        j += height;
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 0, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 0, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 0, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 0, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 0, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 5, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 5, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 5, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 6, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 6, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 6, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 6, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 7, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 7, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 8, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 8, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 8, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 8, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 9, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 9, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 1, j + 9, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 4, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 4, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 4, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 5, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 5, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 5, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 5, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 5, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 6, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 6, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 6, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 6, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 6, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 6, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 7, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 7, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 7, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 7, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 8, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 8, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 8, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 8, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 8, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 8, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 9, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 9, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 9, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 9, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 9, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 10, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 10, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 2, j + 10, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 3, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 4, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 4, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 4, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 4, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 4, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 5, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 5, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 5, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 5, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 5, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 5, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 5, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 6, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 6, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 6, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 6, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 6, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 6, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 0), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 7, k + 8), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 8, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 8, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 8, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 8, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 8, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 8, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 9, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 9, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 9, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 9, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 9, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 9, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 9, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 10, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 10, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 10, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 10, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 10, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 3, j + 11, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 3, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 3, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 4, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 4, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 4, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 4, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 5, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 5, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 5, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 5, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 5, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 5, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 0), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 6, k + 8), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 0), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 7, k + 8), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 0), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 8, k + 8), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 9, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 9, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 9, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 9, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 9, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 9, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 9, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 10, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 10, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 10, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 10, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 10, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 11, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 11, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 4, j + 11, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 3, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 4, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 4, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 4, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 4, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 4, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 5, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 5, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 5, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 5, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 5, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 5, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 5, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 6, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 6, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 6, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 6, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 6, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 6, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 0), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 7, k + 8), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 8, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 8, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 8, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 8, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 8, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 8, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 9, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 9, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 9, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 9, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 9, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 9, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 9, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 10, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 10, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 10, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 10, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 10, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 5, j + 11, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 4, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 4, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 4, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 5, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 5, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 5, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 5, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 5, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 6, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 6, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 6, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 6, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 6, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 6, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 7, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 7, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 7, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 7, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 8, k + 1), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 8, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 8, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 8, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 8, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 8, k + 7), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 9, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 9, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 9, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 9, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 9, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 10, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 10, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 6, j + 10, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 5, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 5, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 5, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 6, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 6, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 6, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 6, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 7, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 7, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 8, k + 2), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 8, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 8, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 8, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 8, k + 6), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 9, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 9, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 7, j + 9, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 8, j + 6, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 8, j + 7, k + 3), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 8, j + 7, k + 4), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 8, j + 7, k + 5), leaves);
		this.setBlockAndNotifyAdequately(world, new BlockPos(i + 8, j + 8, k + 4), leaves);

        return true;
    }
}