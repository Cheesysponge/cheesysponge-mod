package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBirdEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CheeseBirdModel extends GeoModel<CheeseBirdEntity> {
    @Override
    public Identifier getModelResource(CheeseBirdEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "geo/cheesebird.geo.json");
    }

    @Override
    public Identifier getTextureResource(CheeseBirdEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheesebird/cheesebird.png");
    }

    @Override
    public Identifier getAnimationResource(CheeseBirdEntity animatable) {
        return new Identifier(SpongeMod.MOD_ID, "animations/cheesebird.animation.json");
    }

    //@SuppressWarnings({ "unchecked", "rawtypes" })
//    @Override
//    public void setLivingAnimations(CheeseBirdEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
//        super.setLivingAnimations(entity, uniqueID, customPredicate);
//        IBone head = this.getAnimationProcessor().getBone("bone5");
//        //Rotates the birdy by 180 degrees (no longer needed since i fixed backward flying) (Nevermind...)
//        IBone everything = this.getAnimationProcessor().getBone("everything");
//
//        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
//
//        if (everything != null) {
////            everything.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
////            everything.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
//            everything.setRotationX(everything.getRotationX() - 180F);
//        }
//        if (head != null) {
//            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
//            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
//        }
//    }
}