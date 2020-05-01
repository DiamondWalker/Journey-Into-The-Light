package net.journey.blocks.containers;

import net.journey.blocks.tileentity.TileEntityJourneyChest;
import net.journey.init.JourneyTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.tileentity.container.BlockModContainer;

import java.util.Iterator;

public class BlockJourneyChest extends BlockModContainer {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	protected static final AxisAlignedBB NORTH_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0D, 0.9375D, 0.875D, 0.9375D);
	protected static final AxisAlignedBB SOUTH_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 1.0D);
	protected static final AxisAlignedBB WEST_CHEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
	protected static final AxisAlignedBB EAST_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 1.0D, 0.875D, 0.9375D);
	protected static final AxisAlignedBB NOT_CONNECTED_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
	public final BlockJourneyChest.Type chestType;
	public boolean isInitiallyLocked;
	private Item key;

	public BlockJourneyChest(String name, String f, BlockJourneyChest.Type chestTypeIn) {
		this(name, f, chestTypeIn, false, ItemStack.EMPTY.getItem());
	}

	public BlockJourneyChest(String name, String f, BlockJourneyChest.Type chestTypeIn, boolean isInitiallyLocked, Item key) {
		super(EnumMaterialTypes.STONE, name, f, 2.0F, JourneyTabs.MACHINE_BLOCKS);
		this.chestType = chestTypeIn;
		this.isInitiallyLocked = isInitiallyLocked;
		this.key = key;
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasCustomBreakingProgress(IBlockState state) {
		return true;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (source.getBlockState(pos.north()).getBlock() == this) {
			return NORTH_CHEST_AABB;
		} else if (source.getBlockState(pos.south()).getBlock() == this) {
			return SOUTH_CHEST_AABB;
		} else if (source.getBlockState(pos.west()).getBlock() == this) {
			return WEST_CHEST_AABB;
		} else {
			return source.getBlockState(pos.east()).getBlock() == this ? EAST_CHEST_AABB : NOT_CONNECTED_AABB;
		}
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.checkForSurroundingChests(worldIn, pos, state);

		for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
			BlockPos blockpos = pos.offset(enumfacing);
			IBlockState iblockstate = worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() == this) {
				this.checkForSurroundingChests(worldIn, blockpos, iblockstate);
			}
		}
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
	                            ItemStack stack) {
		EnumFacing enumfacing = EnumFacing
				.byHorizontalIndex(MathHelper.floor((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3)
				.getOpposite();
		state = state.withProperty(FACING, enumfacing);
		BlockPos blockpos = pos.north();
		BlockPos blockpos1 = pos.south();
		BlockPos blockpos2 = pos.west();
		BlockPos blockpos3 = pos.east();
		boolean flag = this == worldIn.getBlockState(blockpos).getBlock();
		boolean flag1 = this == worldIn.getBlockState(blockpos1).getBlock();
		boolean flag2 = this == worldIn.getBlockState(blockpos2).getBlock();
		boolean flag3 = this == worldIn.getBlockState(blockpos3).getBlock();

		if (!flag && !flag1 && !flag2 && !flag3) {
			worldIn.setBlockState(pos, state, 3);
		} else if (enumfacing.getAxis() != EnumFacing.Axis.X || !flag && !flag1) {
			if (enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3)) {
				if (flag2) {
					worldIn.setBlockState(blockpos2, state, 3);
				} else {
					worldIn.setBlockState(blockpos3, state, 3);
				}

				worldIn.setBlockState(pos, state, 3);
			}
		} else {
			if (flag) {
				worldIn.setBlockState(blockpos, state, 3);
			} else {
				worldIn.setBlockState(blockpos1, state, 3);
			}

			worldIn.setBlockState(pos, state, 3);
		}

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityJourneyChest) {
				((TileEntityJourneyChest) tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	public IBlockState checkForSurroundingChests(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.isRemote) {
			return state;
		} else {
			IBlockState iblockstate = worldIn.getBlockState(pos.north());
			IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
			IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
			IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
			EnumFacing enumfacing = state.getValue(FACING);

			if (iblockstate.getBlock() != this && iblockstate1.getBlock() != this) {
				boolean flag = iblockstate.isFullBlock();
				boolean flag1 = iblockstate1.isFullBlock();

				if (iblockstate2.getBlock() == this || iblockstate3.getBlock() == this) {
					BlockPos blockpos1 = iblockstate2.getBlock() == this ? pos.west() : pos.east();
					IBlockState iblockstate7 = worldIn.getBlockState(blockpos1.north());
					IBlockState iblockstate6 = worldIn.getBlockState(blockpos1.south());
					enumfacing = EnumFacing.SOUTH;
					EnumFacing enumfacing2;

					if (iblockstate2.getBlock() == this) {
						enumfacing2 = iblockstate2.getValue(FACING);
					} else {
						enumfacing2 = iblockstate3.getValue(FACING);
					}

					if (enumfacing2 == EnumFacing.NORTH) {
						enumfacing = EnumFacing.NORTH;
					}

					if ((flag || iblockstate7.isFullBlock()) && !flag1 && !iblockstate6.isFullBlock()) {
						enumfacing = EnumFacing.SOUTH;
					}

					if ((flag1 || iblockstate6.isFullBlock()) && !flag && !iblockstate7.isFullBlock()) {
						enumfacing = EnumFacing.NORTH;
					}
				}
			} else {
				BlockPos blockpos = iblockstate.getBlock() == this ? pos.north() : pos.south();
				IBlockState iblockstate4 = worldIn.getBlockState(blockpos.west());
				IBlockState iblockstate5 = worldIn.getBlockState(blockpos.east());
				enumfacing = EnumFacing.EAST;
				EnumFacing enumfacing1;

				if (iblockstate.getBlock() == this) {
					enumfacing1 = iblockstate.getValue(FACING);
				} else {
					enumfacing1 = iblockstate1.getValue(FACING);
				}

				if (enumfacing1 == EnumFacing.WEST) {
					enumfacing = EnumFacing.WEST;
				}

				if ((iblockstate2.isFullBlock() || iblockstate4.isFullBlock()) && !iblockstate3.isFullBlock()
						&& !iblockstate5.isFullBlock()) {
					enumfacing = EnumFacing.EAST;
				}

				if ((iblockstate3.isFullBlock() || iblockstate5.isFullBlock()) && !iblockstate2.isFullBlock()
						&& !iblockstate4.isFullBlock()) {
					enumfacing = EnumFacing.WEST;
				}
			}

			state = state.withProperty(FACING, enumfacing);
			worldIn.setBlockState(pos, state, 3);
			return state;
		}
	}

	public IBlockState correctFacing(World worldIn, BlockPos pos, IBlockState state) {
		EnumFacing enumfacing = null;

		for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL) {
			IBlockState iblockstate = worldIn.getBlockState(pos.offset(enumfacing1));

			if (iblockstate.getBlock() == this) {
				return state;
			}

			if (iblockstate.isFullBlock()) {
				if (enumfacing != null) {
					enumfacing = null;
					break;
				}

				enumfacing = enumfacing1;
			}
		}

		if (enumfacing != null) {
			return state.withProperty(FACING, enumfacing.getOpposite());
		} else {
			EnumFacing enumfacing2 = state.getValue(FACING);

			if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock()) {
				enumfacing2 = enumfacing2.getOpposite();
			}

			if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock()) {
				enumfacing2 = enumfacing2.rotateY();
			}

			if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock()) {
				enumfacing2 = enumfacing2.getOpposite();
			}

			return state.withProperty(FACING, enumfacing2);
		}
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		int i = 0;
		BlockPos blockpos = pos.west();
		BlockPos blockpos1 = pos.east();
		BlockPos blockpos2 = pos.north();
		BlockPos blockpos3 = pos.south();

		if (worldIn.getBlockState(blockpos).getBlock() == this) {
			if (this.isDoubleChest(worldIn, blockpos)) {
				return false;
			}

			++i;
		}

		if (worldIn.getBlockState(blockpos1).getBlock() == this) {
			if (this.isDoubleChest(worldIn, blockpos1)) {
				return false;
			}

			++i;
		}

		if (worldIn.getBlockState(blockpos2).getBlock() == this) {
			if (this.isDoubleChest(worldIn, blockpos2)) {
				return false;
			}

			++i;
		}

		if (worldIn.getBlockState(blockpos3).getBlock() == this) {
			if (this.isDoubleChest(worldIn, blockpos3)) {
				return false;
			}

			++i;
		}

		return i <= 1;
	}

	private boolean isDoubleChest(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos).getBlock() == this) {
			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
				if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == this) {
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof TileEntityJourneyChest) {
			tileentity.updateContainingBlockInfo();
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.byIndex(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		return !isDoubleChest(world, pos) && super.rotateBlock(world, pos, axis);
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof IInventory) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			TileEntityJourneyChest chest = (TileEntityJourneyChest) worldIn.getTileEntity(pos);
			if (chest != null) {
				if (chest.isLocked() && canBeOpened(playerIn, worldIn, pos)) {
					chest.setUnlocked();
					if (playerIn.getHeldItemMainhand().getItem() == key) {
						playerIn.getHeldItemMainhand().shrink(1);
					}
				}

				if (chest.isLocked()) { // if still locked after trying to unlock, just skip attempt
					return true;
				}

				playerIn.displayGUIChest(chest);
			}
		}
		return true;
	}

	public boolean canBeOpened(EntityPlayer playerIn, World worldIn, BlockPos pos) {
		return playerIn.getHeldItemMainhand().getItem() == key;
	}

	public ILockableContainer getLockableContainer(World worldIn, BlockPos pos) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (!(tileentity instanceof TileEntityJourneyChest)) {
			return null;
		} else {
			Object object = tileentity;

			if (this.isBlocked(worldIn, pos)) {
				return null;
			} else {
				for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
					BlockPos blockpos1 = pos.offset(enumfacing);
					Block block = worldIn.getBlockState(blockpos1).getBlock();

					if (block == this) {
						if (this.isBlocked(worldIn, blockpos1)) {
							return null;
						}

						TileEntity tileentity1 = worldIn.getTileEntity(blockpos1);

						if (tileentity1 instanceof TileEntityJourneyChest) {
							if (enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH) {
								object = new InventoryLargeChest("container.chestDouble", (ILockableContainer) object, (TileEntityJourneyChest) tileentity1);
							} else {
								object = new InventoryLargeChest("container.chestDouble", (TileEntityJourneyChest) tileentity1, (ILockableContainer) object);
							}
						}
					}
				}

				return (ILockableContainer) object;
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		TileEntityJourneyChest t = new TileEntityJourneyChest();
		if (isInitiallyLocked) t.setLockCode(new LockCode("DUMMY"));
		return t;
	}

	public int isProvidingWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side) {
		if (!this.canProvidePower(state)) {
			return 0;
		} else {
			int i = 0;
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityJourneyChest) {
				i = ((TileEntityJourneyChest) tileentity).numPlayersUsing;
			}

			return MathHelper.clamp(i, 0, 15);
		}
	}

	public int isProvidingStrongPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side) {
		return side == EnumFacing.UP ? this.isProvidingWeakPower(worldIn, pos, state, side) : 0;
	}

	private boolean isBlocked(World worldIn, BlockPos pos) {
		return this.isBelowSolidBlock(worldIn, pos) || this.isOcelotSittingOnChest(worldIn, pos);
	}

	private boolean isBelowSolidBlock(World worldIn, BlockPos pos) {
		return worldIn.isSideSolid(pos.up(), EnumFacing.DOWN, false);
	}

	private boolean isOcelotSittingOnChest(World worldIn, BlockPos pos) {
		Iterator<EntityOcelot> iterator = worldIn
				.getEntitiesWithinAABB(EntityOcelot.class,
						new AxisAlignedBB(pos.getX(), pos.getY() + 1, pos.getZ(),
								pos.getX() + 1, pos.getY() + 2, pos.getZ() + 1))
				.iterator();
		EntityOcelot entityocelot;

		do {
			if (!iterator.hasNext()) {
				return false;
			}

			entityocelot = iterator.next();
		} while (!entityocelot.isSitting());

		return true;
	}

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World worldIn, BlockPos pos) {
		return Container.calcRedstoneFromInventory(this.getLockableContainer(worldIn, pos));
	}

	public enum Type {
		JOURNEY(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestjourney.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestjourney_double.png")),
		NETHER(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestnether.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestnether_double.png")),
		EUCA(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chesteuca.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chesteuca_double.png")),
		BOIL(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestboil.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestboil_double.png")),
		DEPTHS(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestdepths.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestdepths_double.png")),
		CORBA(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestcorba.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestcorba_double.png")),
		TERRA(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestterra.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestterra_double.png")),
		CLOUDIA(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestcloudia.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestcloudia_double.png")),
		FROZEN(new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestfrozen.png"),
				new ResourceLocation(SlayerAPI.MOD_ID, "textures/models/blocks/chestfrozen_double.png"));

		private final ResourceLocation singleChestTexture;
		private final ResourceLocation doubleChestTexture;

		Type(ResourceLocation singleChestTexture, ResourceLocation doubleChestTexture) {
			this.singleChestTexture = singleChestTexture;
			this.doubleChestTexture = doubleChestTexture;
		}

		public ResourceLocation getDoubleChestTexture() {
			return doubleChestTexture;
		}

		public ResourceLocation getSingleChestTexture() {
			return singleChestTexture;
		}
	}
}