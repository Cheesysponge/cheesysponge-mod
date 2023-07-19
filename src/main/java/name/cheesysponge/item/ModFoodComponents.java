package name.cheesysponge.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BURNING_CHEESE = new FoodComponent.Builder().hunger(4).saturationModifier(1.2f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 0.9f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 0.9f).alwaysEdible().build();



}
