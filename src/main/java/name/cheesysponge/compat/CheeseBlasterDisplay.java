package name.cheesysponge.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import name.cheesysponge.recipe.CheeseBlasterRecipe;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.include.com.google.common.collect.ImmutableList;
import java.util.List;

class CheeseBlasterDisplay implements Display {
    private final CheeseBlasterRecipe recipe;
    private final List<EntryIngredient> inputs;
    private final List<EntryIngredient> outputs;
    public CheeseBlasterDisplay(CheeseBlasterRecipe recipe) {
        this.recipe = recipe;
        this.inputs = ImmutableList.of(
                EntryIngredients.ofIngredient(Ingredient.ofItems(Items.COAL)),
                EntryIngredients.ofIngredient(recipe.getTopInput()),
                EntryIngredients.ofIngredient(recipe.getBottomInput()));
        this.outputs = ImmutableList.of(EntryIngredients.of(recipe.getResultItem()));
    }
    @Override
    public List<EntryIngredient> getInputEntries() {
        return inputs;
    }
    @Override
    public List<EntryIngredient> getOutputEntries() {
        return outputs;
    }
    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CheeseBlasterRecipeCategory.CHEESE_BLASTING;
    }
}