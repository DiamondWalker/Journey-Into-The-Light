package net.jitl.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public class JTileContainerBlock extends Block {
    private final BiFunction<BlockState, IBlockReader, TileEntity> tileFactory;

    public JTileContainerBlock(Properties properties, BiFunction<BlockState, IBlockReader, TileEntity> tileFactory) {
        super(properties);
        this.tileFactory = tileFactory;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return tileFactory.apply(state, world);
    }
}
