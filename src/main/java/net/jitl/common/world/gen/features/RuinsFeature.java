package net.jitl.common.world.gen.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import ru.timeconqueror.timecore.util.RandHelper;

import java.util.Random;

public class RuinsFeature extends Feature<NoFeatureConfig> {
	/**
	 * Maximum amount of space between blocks
	 */
	private static final int SPREADING = 5;
	public BlockState[] ruinBlockStates;

	public RuinsFeature(Codec<NoFeatureConfig> codec, BlockState... ruinBlocks) {
		super(codec);
		this.ruinBlockStates = ruinBlocks;
	}

	public BlockState getRandomStates(Random rand) {
		return RandHelper.chooseEqual(rand, ruinBlockStates);
	}

	@Override
	public boolean place(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if (!reader.isEmptyBlock(pos)) {
			return false;
		} else {
			BlockState blockstate = reader.getBlockState(pos.below());
			if (!blockstate.is(Blocks.GRASS_BLOCK) && !blockstate.is(Blocks.SAND) && !blockstate.is(Blocks.PODZOL)) {
				return false;
			} else {
				for (int j1 = 0; j1 < rand.nextInt(3) + 5 /* amount of columns */; j1++) {
					//do stuff here
				}
			}
		}
		return true;
	}
}
