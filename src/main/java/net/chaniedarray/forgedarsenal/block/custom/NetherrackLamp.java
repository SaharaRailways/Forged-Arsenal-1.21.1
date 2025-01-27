package net.chaniedarray.forgedarsenal.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetherrackLamp extends Block {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    public NetherrackLamp(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient) {
            if (state.get(LIT)) {
                //sets LIT to false
                world.setBlockState(pos, state.with(LIT, false));
            } else if(player.isHolding(Items.FLINT_AND_STEEL)) {
                world.setBlockState(pos, state.with(LIT, true));
            }
        }

        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
