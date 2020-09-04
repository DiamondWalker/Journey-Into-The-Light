package net.journey.blocks.containers;

import net.journey.JITL;
import net.journey.api.block.FeatureProvider;
import net.journey.blocks.tileentity.TileEntitySenterianAltar;
import net.journey.blocks.util.Features;
import net.journey.client.render.block.SenterianAltarRenderer;
import net.journey.init.JourneyTabs;
import net.journey.init.items.JourneyItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.entity.tileentity.container.BlockModContainer;
import org.jetbrains.annotations.NotNull;

public class BlockSenterianAltar extends BlockModContainer implements FeatureProvider {

	private final AxisAlignedBB size = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	public BlockSenterianAltar(String name, String finalName) {
		super(name, finalName);
		setCreativeTab(JourneyTabs.INTERACTIVE_BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySenterianAltar();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return size;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return size;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.isRemote) return false;
		Item heldItem = playerIn.getHeldItemMainhand().getItem();
		TileEntitySenterianAltar altar = (TileEntitySenterianAltar)worldIn.getTileEntity(pos);
		if(heldItem != null) {	
			if(altar.orb == null) {
				if(heldItem == JourneyItems.SENTRY_OBSERVER) {//replace with a new item
					altar.orb = heldItem;
					playerIn.getHeldItemMainhand().shrink(1);
					((WorldServer) worldIn).getPlayerChunkMap().markBlockForUpdate(pos);
					return true;
				}
			}

			/*if(heldItem == JourneyItems.ash) {//replace with an item to spawn boss
				if(altar.orb != null) {
					//EntityFrozenTroll mob = new EntityFrozenTroll(worldIn);
					//mob.setLocationAndAngles(pos.getX() + 0.5F, pos.getY() + 1.5F, pos.getZ() + 0.5F, 0.0F, 0.0F);
					//worldIn.spawnEntity(mob);
					//altar.putInOrb(null);
					altar.spawnTimer = 30;
					playerIn.getHeldItemMainhand().shrink(1);
					((WorldServer) worldIn).getPlayerChunkMap().markBlockForUpdate(pos);
					return true;
				}
			}*/
		}
		((WorldServer) worldIn).getPlayerChunkMap().markBlockForUpdate(pos);
		return false;
	}

	@Override
	public @NotNull Features getExtraFeatures() {
		return Features.Builder.create()
				.setCustomItemModelLocation(JITL.rl("block/senterian_altar"))
				.regTEISR(SenterianAltarRenderer.SenterianAltarTEISR::new)
				.build();
	}
}