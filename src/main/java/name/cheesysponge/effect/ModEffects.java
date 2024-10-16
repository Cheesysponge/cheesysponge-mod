package name.cheesysponge.effect;

import name.cheesysponge.SpongeMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModEffects {
    public static StatusEffect CHEESE;

    public static StatusEffect registerStatusEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(SpongeMod.MOD_ID, name),
                new CheeseEffect(StatusEffectCategory.BENEFICIAL, 13607215));
    }

    public static void registerEffects(){
        CHEESE = registerStatusEffect("cheese");
    }
}
