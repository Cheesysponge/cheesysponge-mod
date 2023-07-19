package name.cheesysponge.block;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.custom.CheesyBlock;
import name.cheesysponge.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import java.util.List;


public class ModBlocks {

    public static final Block CHEESYSPONGE_BLOCK = registerBlock("cheesysponge_block",
            new Block(FabricBlockSettings.of(Material.SPONGE).strength(8f).requiresTool().luminance(200)), ModItemGroup.CHEESY_SPONGE, "tooltip.cheesysponge.cheesysponge_block");
    public static final Block CHEESYSPONGE_ORE = registerBlock("cheesysponge_ore",
            new Block(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block DEEPSLATE_CHEESYSPONGE_ORE = registerBlock("deepslate_cheesysponge_ore",
            new Block(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_BLOCK = registerBlock("cheesy_block",
            new CheesyBlock(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_BUTTON = registerBlock("cheesy_sponge_button",
            new StoneButtonBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_PRESSURE_PLATE = registerBlock("cheesy_sponge_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING ,FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_FENCE = registerBlock("cheesy_sponge_fence",
            new FenceBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_FENCE_GATE = registerBlock("cheesy_sponge_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_WALL = registerBlock("cheesy_sponge_wall",
            new WallBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool()), ModItemGroup.CHEESY_SPONGE);

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(SpongeMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(SpongeMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }

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
