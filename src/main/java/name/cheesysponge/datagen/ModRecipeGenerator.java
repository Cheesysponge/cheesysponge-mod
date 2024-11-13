package name.cheesysponge.datagen;

import name.cheesysponge.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeGenerator(Items.APPLE,Items.YELLOW_DYE, ModItems.BANANA, exporter);

    }

    public void ShapelessRecipeGenerator(Item First,Item Second, Item output, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(First)
                .input(Second)
                .criterion(FabricRecipeProvider.hasItem(First),
                        FabricRecipeProvider.conditionsFromItem(First))
                .criterion(FabricRecipeProvider.hasItem(Second),
                        FabricRecipeProvider.conditionsFromItem(Second))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
}