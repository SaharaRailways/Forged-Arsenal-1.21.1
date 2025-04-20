package net.chaniedarray.forgedarsenal;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModPackets {

    public static final Identifier HIGHLIGHT_PACKET_ID = Identifier.of(ForgedArsenal.MOD_ID, "highlight_block");

    /*public static void send(ServerPlayerEntity player, Identifier channelName, PacketByteBuf buf) {
        ServerPlayNetworking.send((ServerPlayerEntity) user, TutorialNetworkingConstants.HIGHLIGHT_PACKET_ID, PacketByteBufs.empty());
        return TypedActionResult.success(user.getHandStack(hand));
    }

    ClientPlayNetworking.registerGlobalReceiver(TutorialNetworkingConstants.HIGHLIGHT_PACKET_ID, (client, handler, buf, responseSender) -> {
        client.execute(() -> {
            // Everything in this lambda is run on the render thread
        });
    });
    */
    public static void register() {
        // Register your packets here
        // Example: PacketRegistry.registerPacket(MOD_ID, new YourPacket());
    }
    public record BlockHighlightPayload(BlockPos blockPos) implements CustomPayload {
        public static final CustomPayload.Id<BlockHighlightPayload> ID = new CustomPayload.Id<>(ModPackets.HIGHLIGHT_PACKET_ID);
        public static final PacketCodec<RegistryByteBuf, BlockHighlightPayload> CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, BlockHighlightPayload::blockPos, BlockHighlightPayload::new);
        // should you need to send more data, add the appropriate record parameters and change your codec:
        // public static final PacketCodec<RegistryByteBuf, BlockHighlightPayload> CODEC = PacketCodec.tuple(
        //         BlockPos.PACKET_CODEC, BlockHighlightPayload::blockPos,
        //         PacketCodecs.INTEGER, BlockHighlightPayload::myInt,
        //         Uuids.PACKET_CODEC, BlockHighlightPayload::myUuid,
        //         BlockHighlightPayload::new
        // );

        @Override
        public CustomPayload.Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
}
