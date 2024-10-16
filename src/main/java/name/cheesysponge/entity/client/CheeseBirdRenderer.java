package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBirdEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CheeseBirdRenderer extends GeoEntityRenderer<CheeseBirdEntity> {
    public CheeseBirdRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CheeseBirdModel());
    }

    @Override
    public Identifier getTextureLocation(CheeseBirdEntity instance) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheesebird/cheesebird.png");
    }

    @Override
    public RenderLayer getRenderType(CheeseBirdEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }


}