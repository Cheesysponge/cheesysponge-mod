package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBossEntity;
import name.cheesysponge.entity.custom.CheeseEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CheeseBossModel extends AnimatedGeoModel<CheeseBossEntity> {
    @Override
    public Identifier getModelLocation(CheeseBossEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "geo/cheeseboss.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CheeseBossEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheeseboss/cheeseboss.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CheeseBossEntity animatable) {
        return new Identifier(SpongeMod.MOD_ID, "animations/cheeseboss.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(CheeseBossEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}