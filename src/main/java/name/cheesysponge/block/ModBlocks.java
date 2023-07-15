package name.cheesysponge.block;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CHEESYSPONGE_BLOCK = registerBlock("cheesysponge_block",
            new Block(FabricBlockSettings.of(Material.SPONGE).strength(8f).requiresTool().luminance(200)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESYSPONGE_ORE = registerBlock("cheesysponge_ore",
            new Block(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block DEEPSLATE_CHEESYSPONGE_ORE = registerBlock("deepslate_cheesysponge_ore",
            new Block(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool()), ModItemGroup.CHEESY_SPONGE);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block , group);
        return Registry.register(Registry.BLOCK, new Identifier(SpongeMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(SpongeMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        SpongeMod.LOGGER.info("Registering ModBlocks for " + SpongeMod.MOD_ID);
    }

}
