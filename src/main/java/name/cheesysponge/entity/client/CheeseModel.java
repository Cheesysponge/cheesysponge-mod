package name.cheesysponge.entity.client;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CheeseModel extends AnimatedGeoModel<CheeseEntity> {
    @Override
    public Identifier getModelLocation(CheeseEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "geo/cheese.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CheeseEntity object) {
        return new Identifier(SpongeMod.MOD_ID, "textures/entity/cheese/cheese.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CheeseEntity animatable) {
        return new Identifier(SpongeMod.MOD_ID, "animations/cheese.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(CheeseEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
