package name.cheesysponge.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class CheeseBlasterRecipeCategory implements DisplayCategory<CheeseBlasterDisplay> {
    public static final Identifier Texture =
            new Identifier(SpongeMod.MOD_ID,"textures/gui/alloy_blaster_cooked1.png");
    public static final CategoryIdentifier<CheeseBlasterDisplay> CHEESE_BLASTING =
            CategoryIdentifier.of(SpongeMod.MOD_ID, "alloy_blaster");
    @Override
    public CategoryIdentifier<? extends CheeseBlasterDisplay> getCategoryIdentifier() {
        return CHEESE_BLASTING;
    }
    @Override
    public Text getTitle() {
        return Text.literal("Cheese Blaster");
    }
    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.CHEESE_BLASTER.asItem().getDefaultStack());
    }
    @Override
    public List<Widget> setupDisplay(CheeseBlasterDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() -87, bounds.getCenterY()-35);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createTexturedWidget(Texture, new Rectangle(startPoint.x, startPoint.y, 176, 78)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 18, startPoint.y + 50))
                .entries(display.getRequiredEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 66, startPoint.y + 16))
                .entries(display.getInputEntries().get(1)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 66, startPoint.y + 50))
                .entries(display.getInputEntries().get(2)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 114, startPoint.y + 33))
                .markOutput().entries(display.getOutputEntries().get(0)));
        return widgets;
    }
    @Override
    public int getDisplayHeight() {
        return 94;
    }
    @Override
    public int getDisplayWidth(CheeseBlasterDisplay display) {
        return 175;
    }
}