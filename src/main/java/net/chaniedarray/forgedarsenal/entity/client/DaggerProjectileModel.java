package net.chaniedarray.forgedarsenal.entity.client;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.chaniedarray.forgedarsenal.entity.custom.DaggerProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DaggerProjectileModel extends EntityModel<DaggerProjectileEntity> {
    public static final EntityModelLayer DAGGER = new EntityModelLayer(Identifier.of(ForgedArsenal.MOD_ID, "dagger"), "main");
    private final ModelPart dagger;

    public DaggerProjectileModel(ModelPart root) {this.dagger = root.getChild("dagger");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData tomahawk = modelPartData.addChild("dagger", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.5F, 0.0F));

        ModelPartData cube_r1 = tomahawk.addChild("cube_r1", ModelPartBuilder.create().uv(8, 7).cuboid(1.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, -4.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r2 = tomahawk.addChild("cube_r2", ModelPartBuilder.create().uv(7, 9).cuboid(0.5F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r3 = tomahawk.addChild("cube_r3", ModelPartBuilder.create().uv(3, 10).cuboid(-2.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r4 = tomahawk.addChild("cube_r4", ModelPartBuilder.create().uv(1, 4).cuboid(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r5 = tomahawk.addChild("cube_r5", ModelPartBuilder.create().uv(18, 1).cuboid(-0.5F, -9.0F, -0.5F, 1.0F, 18.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 0.0F, 0.0F, -0.7854F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(DaggerProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        dagger.render(matrices, vertexConsumer, light, overlay, color);
    }
}
