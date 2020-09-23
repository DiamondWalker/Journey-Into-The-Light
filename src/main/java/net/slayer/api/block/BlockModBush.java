package net.slayer.api.block;

import net.journey.init.JourneyTabs;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.slayer.api.EnumMaterialTypes;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockModBush extends BlockMod implements IPlantable, IGrowable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 2);
	protected static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);
	private final boolean isNether;
	private final Item berry;

	public BlockModBush(String name, String finalName, Item berry, boolean isNether) {
		super(EnumMaterialTypes.LEAVES, name, finalName, 1.0F);
		this.berry = berry;
		this.isNether = isNether;
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
		this.setTickRandomly(true);
		this.setLightOpacity(-100000);
		this.setCreativeTab(JourneyTabs.CROPS);
	}

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BUSH_AABB;
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

	@Override
	public boolean canPlaceBlockAt(World w, BlockPos pos) {
		Block block = w.getBlockState(pos.down()).getBlock();
		if (isNether) {
			return block == Blocks.NETHERRACK;
		}
		return block == Blocks.GRASS || block == Blocks.DIRT;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(AGE);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, AGE);
	}


	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return state.getValue(AGE) < 2;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return null;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.getDefaultState();
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote && state.getValue(AGE) < 2) {
			worldIn.setBlockState(pos, state.withProperty(AGE, state.getValue(AGE) + 1), 2);
		}
	}

	@Override
	public void updateTick(World w, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(w, pos, state, rand);
		if (w.rand.nextInt(15) == 0) {
			int age = state.getValue(AGE);
			if (age < 2) {
				w.setBlockState(pos, state.withProperty(AGE, age + 1), 2);
			}
		}
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		if (plantable instanceof BlockModBush && state.getPropertyKeys().contains(AGE)) {
			return (state.getValue(AGE) > 2);
		}

		return super.canSustainPlant(state, world, pos, direction, plantable);
	}
	
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		double
				x = player.posX,
				y = player.posY,
				z = player.posZ;

		//uhhh what?
		if (w.isRemote) {
			return true;
		}

		if (state.getValue(AGE) == 2) {
			EntityItem drop = new EntityItem(w, x, y, z, new ItemStack(berry, w.rand.nextInt(3) + 1));
			w.spawnEntity(drop);
			w.setBlockState(pos, state.withProperty(AGE, 0));
			return true;
		} else {
			return false;
		}
	}
}