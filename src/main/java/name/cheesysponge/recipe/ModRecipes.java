package name.cheesysponge.recipe;

import name.cheesysponge.SpongeMod;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(SpongeMod.MOD_ID, CheeseBlasterRecipe.Serializer.ID), CheeseBlasterRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(SpongeMod.MOD_ID, CheeseBlasterRecipe.Type.ID), CheeseBlasterRecipe.Type.INSTANCE);
    }
}
