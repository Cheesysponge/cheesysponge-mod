package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;


public class CheeseModel extends GeoModel<CheeseEntity> {
    @Override
    public Identifier getModelResource(CheeseEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "geo/cheese.geo.json");
    }

    @Override
    public Identifier getTextureResource(CheeseEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheese/cheese.png");
    }

    @Override
    public Identifier getAnimationResource(CheeseEntity animatable) {
        return new Identifier(SpongeMod.MOD_ID, "animations/cheese.animation.json");
    }

//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    @Override
//    public void setLivingAnimations(CheeseEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
//        super.setLivingAnimations(entity, uniqueID, customPredicate);
//        IBone head = this.getAnimationProcessor().getBone("head");
//
//        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
//        if (head != null) {
//            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
//            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
//        }
//    }
}