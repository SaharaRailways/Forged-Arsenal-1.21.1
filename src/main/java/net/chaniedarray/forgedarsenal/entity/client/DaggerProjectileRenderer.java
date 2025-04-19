package net.chaniedarray.forgedarsenal.entity.client;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.chaniedarray.forgedarsenal.entity.custom.DaggerProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class DaggerProjectileRenderer extends EntityRenderer<DaggerProjectileEntity> {
    protected  DaggerProjectileModel model;


    public DaggerProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new DaggerProjectileModel(ctx.getPart(DaggerProjectileModel.DAGGER));
    }

    @Override
    public void render(DaggerProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        if(!entity.isGrounded()) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw())));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.getRenderingRotation() * 5f));
            matrices.translate(0, -1.0f, 0);
        } else {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.groundedOffset.y)); //the .x and .y used to be getX() and getY(), but it didn't work idk
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.groundedOffset.x));
            matrices.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(ForgedArsenal.MOD_ID, "textures/entity/tomahawk/tomahawk.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(DaggerProjectileEntity entity) {
        return Identifier.of(ForgedArsenal.MOD_ID, "textures/entity/tomahawk/tomahawk.png");
    }
}