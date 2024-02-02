package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBirdEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CheeseBirdRenderer extends GeoEntityRenderer<CheeseBirdEntity> {
    public CheeseBirdRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CheeseBirdModel());
    }

    @Override
    public Identifier getTextureLocation(CheeseBirdEntity instance) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheesebird/cheesebird.png");
    }

    @Override
    public RenderLayer getRenderType(CheeseBirdEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1f, 1f);


        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder,
                packedLightIn, textureLocation);
    }
}