package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBirdEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CheeseBirdModel extends AnimatedGeoModel<CheeseBirdEntity> {
    @Override
    public Identifier getModelLocation(CheeseBirdEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "geo/cheesebird.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CheeseBirdEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheesebird/cheesebird.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CheeseBirdEntity animatable) {
        return new Identifier(SpongeMod.MOD_ID, "animations/cheesebird.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(CheeseBirdEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("bone5");
        //Rotates the birdy by 180 degrees (no longer needed since i fixed backward flying)
//        IBone everything = this.getAnimationProcessor().getBone("everything");
//        if (everything != null) {
//            everything.setRotationX(everything.getRotationX() - 180F);
//        }
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}