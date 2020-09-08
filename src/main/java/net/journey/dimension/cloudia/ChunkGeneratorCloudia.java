package net.journey.dimension.cloudia;

import net.journey.dimension.cloudia.zone.*;
import net.journey.init.blocks.JourneyBlocks;
import net.journey.util.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.*;

public class ChunkGeneratorCloudia implements IChunkGenerator {

	private final ArrayList bottomrooms;
	private final ArrayList toprooms;
	private final CloudiaEmptyChunk emptyChunk;
	private final CloudiaZoneBase[] bridges;
	private final World world;
	private final Random random;
	private final Map chunkTileEntityMap;
	private Biome[] biomesForGeneration;

	private final WorldGenMinable pinkCloudiaCloud;
	private final WorldGenMinable lightBlueCloudiaCloud;
	private final WorldGenMinable cloudiaRock;
	private final WorldGenMinable luniteOre;

	public ChunkGeneratorCloudia(World worldIn, long seed) {
		world = worldIn;
		random = new Random(seed);
		bottomrooms = new ArrayList(4);
		bottomrooms.add(new CloudiaDungeon1());
		bottomrooms.add(new CloudiaAltar());
		bottomrooms.add(new CloudiaDungeon2());
		bottomrooms.add(new CloudiaGarden());

		emptyChunk = new CloudiaEmptyChunk();

		toprooms = new ArrayList(2);
		toprooms.add(new CloudiaHouse1());
		toprooms.add(new CloudiaAltarRoom1());

		bridges = new CloudiaZoneBase[]{new CloudiaBridgeAll()/*, new CloudiaBridgeNS(), new CloudiaBridgeEW()*/};
		this.chunkTileEntityMap = new HashMap();
		
        pinkCloudiaCloud = new WorldGenMinable(JourneyBlocks.pinkCloudiaCloud.getDefaultState(), 40, BlockStateMatcher.forBlock(Blocks.AIR));
        lightBlueCloudiaCloud = new WorldGenMinable(JourneyBlocks.lightBlueCloudiaCloud.getDefaultState(), 40, BlockStateMatcher.forBlock(Blocks.AIR));
        
        cloudiaRock = new WorldGenMinable(JourneyBlocks.cloudiaRock.getDefaultState(), 40, BlockStateMatcher.forBlock(Blocks.AIR));
        luniteOre = new WorldGenMinable(JourneyBlocks.luniteOre.getDefaultState(), Config.luniteOreGenAmount, BlockStateMatcher.forBlock(JourneyBlocks.cloudiaRock));
	}

	@Override
	public Chunk generateChunk(int chunkX, int chunkZ) {
		CloudiaChunkPrimer cloudiaChunk = new CloudiaChunkPrimer();
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		int bottomLayer = 32;
		int secondLayer = 51;

		//Generates all rooms
		CloudiaZoneBase room = (CloudiaZoneBase) (toprooms.get(random.nextInt(toprooms.size())));
		CloudiaZoneBase room2 = (CloudiaZoneBase) (bottomrooms.get(random.nextInt(bottomrooms.size())));

		int emptyRarity = 2;

		int hallwayRarity = emptyRarity * 2;
		if (random.nextInt(hallwayRarity) == 0)
			bridges[random.nextInt(bridges.length)].generate(cloudiaChunk, random, 0, bottomLayer, 0);

		if (random.nextInt(hallwayRarity) == 0)
			bridges[random.nextInt(bridges.length)].generate(cloudiaChunk, random, 0, secondLayer, 0);

		room = (CloudiaZoneBase) (toprooms.get(random.nextInt(toprooms.size())));
		if (random.nextInt(emptyRarity) != 0)
			room.generate(cloudiaChunk, random, 0, secondLayer, 0);

		room2 = (CloudiaZoneBase) (bottomrooms.get(random.nextInt(bottomrooms.size())));
		if (random.nextInt(emptyRarity) != 0)
			room2.generate(cloudiaChunk, random, 0, bottomLayer, 0);

		//checks all tile entitys
		chunkTileEntityMap.put(new ChunkPos(chunkX, chunkZ), cloudiaChunk.chunkTileEntityPositions);

		Chunk chunk = new Chunk(this.world, cloudiaChunk, chunkX, chunkZ);
		byte[] abyte = chunk.getBiomeArray();

		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(int chunkX, int chunkZ) {
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BlockPos pos = new BlockPos(x, 0, z);
		Biome biome = this.world.getBiome(pos.add(16, 0, 16));
		this.random.setSeed(this.world.getSeed());
		long k = this.random.nextLong() / 2L * 2L + 1L;
		long l = this.random.nextLong() / 2L * 2L + 1L;
		ChunkPos chunkpos = new ChunkPos(chunkX, chunkZ);
		this.random.setSeed((long) chunkX * k + (long) chunkZ * l ^ this.world.getSeed());
		BlockPos chunkStart = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		//checks all tile entitys in the world and updates (renders) them
		List<BlockPos> chunkTileEntityPositions = (List<BlockPos>) chunkTileEntityMap.get(chunkpos);
		if (chunkTileEntityPositions != null) {
			Chunk chunk = this.world.getChunk(chunkX, chunkZ);
			for (int i = 0; i < chunkTileEntityPositions.size(); i++) {
				BlockPos chunkPosition = chunkTileEntityPositions.get(i);
				IBlockState state = chunk.getBlockState(chunkPosition.getX(), chunkPosition.getY(),
						chunkPosition.getZ());
				TileEntity te = state.getBlock().createTileEntity(this.world, state);
				this.world.setTileEntity(chunkPosition.add(x, 0, z), te);
			}
			chunkTileEntityMap.remove(chunkpos);
		}

		WorldEntitySpawner.performWorldGenSpawning(this.world, biome, x + 8, z + 8, 16, 16, this.random);


		if (random.nextInt(3) == 0) {
			cloudiaRock.generate(world, random, chunkStart.add(random.nextInt(16), random.nextInt(world.getHeight()), random.nextInt(16)));
		}

		if (random.nextInt(3) == 0) {
			luniteOre.generate(world, random, chunkStart.add(random.nextInt(16), random.nextInt(world.getHeight()), random.nextInt(16)));
		}

		for(int i = 0; i < 2; i++) {
			BlockPos p = chunkStart.add(random.nextInt(16), random.nextInt(world.getHeight()), random.nextInt(16));
			if (10 < p.getY() && p.getY() < 120)
				pinkCloudiaCloud.generate(world, random, p);
		}

		for(int i = 0; i < 2; i++) {
			BlockPos p = chunkStart.add(random.nextInt(16), random.nextInt(world.getHeight()), random.nextInt(16));
			if (10 < p.getY() && p.getY() < 120)
				lightBlueCloudiaCloud.generate(world, random, p);
		}

	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		Biome biome = this.world.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return false;
	}
}