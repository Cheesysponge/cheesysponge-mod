package name.cheesysponge.potion;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.effect.ModEffects;
import name.cheesysponge.item.ModItems;
import name.cheesysponge.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModPotions {
    public static Potion CHEESE_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registries.POTION, new Identifier(SpongeMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.CHEESE, 240, 0)));
    }

    public static void registerPotions() {
        CHEESE_POTION = registerPotion("cheese_potion");

        registerPotionRecipes();
    }
    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.BURNING_CHEESE, ModPotions.CHEESE_POTION);
    }
}