package name.cheesysponge.item;

import name.cheesysponge.SpongeMod;
import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ModItems {
    public static final Item SPONGE_INGOT = registerItem("sponge_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item CHEESY_SPONGE = registerItem("cheesy_sponge", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ItemGroup.MISC).maxCount(12)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SpongeMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        SpongeMod.LOGGER.info("Registering Mod Items for " + SpongeMod.MOD_ID);
    }
}
