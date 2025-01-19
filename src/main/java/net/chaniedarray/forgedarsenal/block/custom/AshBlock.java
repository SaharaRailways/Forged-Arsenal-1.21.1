package net.chaniedarray.forgedarsenal.block.custom;

import net.chaniedarray.forgedarsenal.item.ModItems;
import net.chaniedarray.forgedarsenal.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class AshBlock extends Block {
    public AshBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.getStackInHand(player.getActiveHand()).getItem() == ModItems.MOLTEN_IRON) {
            if (!world.isClient) {
                player.getStackInHand(player.getActiveHand()).decrement(1);
                player.giveItemStack(new ItemStack(ModItems.SMOLDERING_ALLOY, 1));
            }
            world.playSound(player, pos, SoundEvents.ITEM_BRUSH_BRUSHING_GRAVEL, SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(ModItems.SMOLDERING_ALLOY, itemEntity.getStack().getCount()));
            }
        }
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.MOLTON_INGOTS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.forgedarsenal.ash_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
