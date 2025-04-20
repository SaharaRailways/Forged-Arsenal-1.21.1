package net.chaniedarray.forgedarsenal.item.custom;

import net.chaniedarray.forgedarsenal.ForgedArsenalClient;
import net.chaniedarray.forgedarsenal.ModPackets;
import net.chaniedarray.forgedarsenal.entity.custom.DaggerProjectileEntity;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicReference;

public class DaggerItem extends Item {
    public DaggerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            DaggerProjectileEntity dagger = new DaggerProjectileEntity(world, user);
            dagger.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 0f);
            world.spawnEntity(dagger);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public static void handleKeyPress(World world, PlayerEntity user) {
        if (/*!world.isClient && */ForgedArsenalClient.recallKeyBinding.wasPressed()) {
            recallDaggers(world, user);
            System.out.println("Recall key pressed");
        } else {
            System.out.println("Recall key not pressed");
        }
    }

    private static void recallDaggers(World world, PlayerEntity user) {
        double[] closestDaggerRange = {40.0};
        AtomicReference<DaggerProjectileEntity> closestDagger = new AtomicReference<>(null);

        world.getEntitiesByClass(DaggerProjectileEntity.class, user.getBoundingBox().expand(closestDaggerRange[0]), dagger ->
                dagger.getOwnerUuid() != null && dagger.getOwnerUuid().equals(user.getUuid())
        ).forEach(dagger -> {
            // saves dagger if the distance is less than the closestDaggerRange
            if (closestDagger.get() == null || dagger.squaredDistanceTo(user) < closestDaggerRange[0]) {
                closestDagger.set(dagger);
                closestDaggerRange[0] = (double) dagger.squaredDistanceTo(user);
            }
        });
        if (closestDagger.get() != null) {
            closestDagger.get().setPosition(user.getX(), user.getY() + 1.5, user.getZ());
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeUuid(closestDagger.get().getUuid());

            ServerPlayNetworking.send((ServerPlayerEntity) user, ModPackets.HIGHLIGHT_PACKET_ID, PacketByteBufs.empty());

        }
    }
}
