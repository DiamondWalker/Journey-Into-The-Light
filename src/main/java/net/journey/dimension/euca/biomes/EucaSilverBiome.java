package net.journey.dimension.euca.biomes;

import net.journey.dimension.base.gen.JWorldGenPlants;
import net.journey.dimension.euca.gen.trees.WorldGenEucaTree;
import net.journey.init.blocks.JourneyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class EucaSilverBiome extends EucaBiome {

	private final JWorldGenPlants SILVER_TALL_GRASS = new JWorldGenPlants(JourneyBlocks.eucaSilverTallGrass, EUCA_SILVER_GRASS_GROUND, 25);
	private final JWorldGenPlants SILVER_SPROUT = new JWorldGenPlants(JourneyBlocks.eucaSilverSprouts, EUCA_SILVER_GRASS_GROUND);
	private final JWorldGenPlants SILVER_GOLD_FLOWER = new JWorldGenPlants(JourneyBlocks.eucaSilverGoldFlower, EUCA_SILVER_GRASS_GROUND);
	private final JWorldGenPlants SILVER_SHORT_GRASS = new JWorldGenPlants(JourneyBlocks.eucaSilverShortGrass, EUCA_SILVER_GRASS_GROUND, 25);

	private final WorldGenerator[] FLOWERS = new WorldGenerator[]{SILVER_TALL_GRASS, SILVER_SHORT_GRASS, SILVER_SPROUT, SILVER_GOLD_FLOWER};

	public EucaSilverBiome(BiomeProperties properties, IBlockState topBlock, IBlockState fillerBlock) {
		super(properties, topBlock, fillerBlock);
		decorator.treesPerChunk = 2;
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos chunkStart) {
		for (WorldGenerator flowerGen : FLOWERS) {
			int j = rand.nextInt(8);
			int k = rand.nextInt(8);
			flowerGen.generate(worldIn, rand, chunkStart.add(j, 0, k));
		}
		super.decorate(worldIn, rand, chunkStart);
	}

	@Override
	public @NotNull WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		Block leaves = JourneyBlocks.eucaSilverLeaves;
		WorldGenAbstractTree tree = new WorldGenEucaTree(true, JourneyBlocks.eucaGoldLog, leaves, 6, (rand.nextInt(2) + 3));
		return tree;
	}
}
