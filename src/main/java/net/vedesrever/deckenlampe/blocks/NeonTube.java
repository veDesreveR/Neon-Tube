package net.vedesrever.deckenlampe.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.RodBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.vedesrever.deckenlampe.util.IRegisterableBlock;

public class NeonTube extends RodBlock implements IRegisterableBlock {

  public NeonTube() {
    super(
        FabricBlockSettings
            .of(Material.GLASS)
            .strength(0.5F)
            .luminance(15)
            .requiresTool()
            .sounds(BlockSoundGroup.GLASS)
    );
    setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
  }

  public BlockState getPlacementState(ItemPlacementContext ctx) {
    Direction direction = ctx.getSide();
    BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));
    return blockState.isOf(this) && blockState.get(FACING) == direction ? getDefaultState().with(FACING, direction.getOpposite()) : getDefaultState().with(FACING, direction);
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
}
