package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBirdEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.example.entity.DynamicExampleEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
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
        if(animatable.isBaby()) {
            //stack.scale(0.6f, 0.6f, 0.6f);
        } else {
            //bufferSource.scale(1.4f, 1.4f, 1.4f);
        }
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }




}