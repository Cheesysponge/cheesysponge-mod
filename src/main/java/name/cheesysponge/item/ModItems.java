package name.cheesysponge.item;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.item.custom.SpongeRodItem;
import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ModItems {
    public static final Item SPONGE_INGOT = registerItem("sponge_ingot", new Item(new FabricItemSettings().group(ModItemGroup.CHEESY_SPONGE)));
    public static final Item CHEESY_SPONGE = registerItem("cheesy_sponge", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(12)));
    public static final Item RAW_CHEESY_SPONGE = registerItem("raw_cheesy_sponge", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(12)));
    public static final Item CHEESY_SPONGE_ROD = registerItem("cheesy_sponge_rod", new SpongeRodItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1).maxDamage(100)));
    public static final Item BURNING_CHEESE = registerItem("burning_cheese", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(2).food(ModFoodComponents.BURNING_CHEESE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SpongeMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        SpongeMod.LOGGER.info("Registering Mod Items for " + SpongeMod.MOD_ID);
    }
}
