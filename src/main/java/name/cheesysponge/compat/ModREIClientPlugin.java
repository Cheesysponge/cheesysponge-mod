package name.cheesysponge.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.recipe.CheeseBlasterRecipe;
import name.cheesysponge.recipe.ModRecipes;
import name.cheesysponge.screen.CheeseBlasterScreen;
import net.minecraft.item.ItemStack;
public class ModREIClientPlugin implements REIClientPlugin{
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CheeseBlasterRecipeCategory());
        registerWorkingStations(registry);
    }
    @Override
    public String getPluginProviderName() {
        return "AdvancedCheeses";
    }
    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CheeseBlasterRecipe.class, CheeseBlasterRecipe.Type.INSTANCE, CheeseBlasterDisplay::new);
    }
    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerContainerClickArea(
                new Rectangle(75, 30, 20, 30),
                CheeseBlasterScreen.class,
                CheeseBlasterRecipeCategory.CHEESE_BLASTING);
    }
    private void registerWorkingStations(CategoryRegistry registry) {
        ItemStack inscriber = new ItemStack(ModBlocks.CHEESE_BLASTER);
        registry.addWorkstations(CheeseBlasterRecipeCategory.CHEESE_BLASTING, EntryStacks.of(inscriber));
    }
}
