package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBossEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CheeseBossRenderer extends GeoEntityRenderer<CheeseBossEntity> {
    public CheeseBossRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CheeseBossModel());
    }

    @Override
    public Identifier getTextureLocation(CheeseBossEntity instance) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheeseboss/cheeseboss.png");
    }

    @Override
    public RenderLayer getRenderType(CheeseBossEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }

//    @Override
//    public RenderLayer getRenderType(CheeseBossEntity animatable, float partialTicks, MatrixStack stack,
//                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
//                                     int packedLightIn, Identifier textureLocation) {
//        if(animatable.isBaby()) {
//            stack.scale(0.6f, 0.6f, 0.6f);
//        } else {
//            stack.scale(1.4f, 1.4f, 1.4f);
//        }
//
//        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder,
//                packedLightIn, textureLocation);
//    }
}