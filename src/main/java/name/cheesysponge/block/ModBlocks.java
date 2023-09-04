package name.cheesysponge.block;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.custom.*;
import name.cheesysponge.item.ModItemGroup;
import name.cheesysponge.sound.ModSounds;
import name.cheesysponge.world.feature.tree.SpongeSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import java.util.List;


public class ModBlocks {

    public static final Block CHEESYSPONGE_BLOCK = registerBlock("cheesysponge_block",
            new Block(FabricBlockSettings.of(Material.SPONGE).strength(8f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE, "tooltip.cheesysponge.cheesysponge_block");
    public static final Block CHEESYSPONGE_ORE = registerBlock("cheesysponge_ore",
            new OreBlock(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool().luminance(16), UniformIntProvider.create(2,6)), ModItemGroup.CHEESY_SPONGE);
    public static final Block DEEPSLATE_CHEESYSPONGE_ORE = registerBlock("deepslate_cheesysponge_ore",
            new OreBlock(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool().luminance(16), UniformIntProvider.create(2,6)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_BLOCK = registerBlock("cheesy_block",
            new CheesyBlock(FabricBlockSettings.of(Material.SPONGE).strength(4f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_BUTTON = registerBlock("cheesy_sponge_button",
            new StoneButtonBlock(FabricBlockSettings.of(Material.SPONGE).strength(1f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_PRESSURE_PLATE = registerBlock("cheesy_sponge_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING ,FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_FENCE = registerBlock("cheesy_sponge_fence",
            new FenceBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_FENCE_GATE = registerBlock("cheesy_sponge_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_WALL = registerBlock("cheesy_sponge_wall",
            new WallBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);

    public static final Block CHEESY_SPONGE_SLAB = registerBlock("cheesy_sponge_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_STAIRS = registerBlock("cheesy_sponge_stairs",
            new StairsBlock(ModBlocks.CHEESYSPONGE_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_DOOR = registerBlock("cheesy_sponge_door",
            new DoorBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().luminance(16).nonOpaque()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_TRAPDOOR = registerBlock("cheesy_sponge_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.of(Material.SPONGE).strength(3f).requiresTool().nonOpaque().luminance(16)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_FLOWER = registerBlock("cheesy_sponge_flower",
            new FlowerBlock(StatusEffects.HEALTH_BOOST,1000,FabricBlockSettings.copy(Blocks.DANDELION).strength(3f).nonOpaque().requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block POTTED_CHEESY_SPONGE_FLOWER = registerBlockWithoutBlockItem("potted_cheesy_sponge_flower",
            new FlowerPotBlock(ModBlocks.CHEESY_SPONGE_FLOWER,FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).nonOpaque()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_LAMP = registerBlock("cheesy_sponge_lamp",
            new CheesySpongeLampBlock(FabricBlockSettings.of(Material.SPONGE).strength(8f).requiresTool().sounds(ModSounds.CHEESY_SPONGE_SOUNDS).luminance((state) -> state.get(CheesySpongeLampBlock.CLICKED) ? 15 : 0)), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESY_SPONGE_GLASS = registerBlock("cheesy_sponge_glass",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(3f).nonOpaque()), ModItemGroup.CHEESY_SPONGE);
    public static final Block SPONGE_WEED = registerBlockWithoutBlockItem("sponge_weed",
            new SpongeWeedBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()), ModItemGroup.CHEESY_SPONGE);
    public static final Block SPONGE_LOG = registerBlock("sponge_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4.0f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block SPONGE_WOOD = registerBlock("sponge_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(4.0f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block STRIPPED_SPONGE_LOG = registerBlock("stripped_sponge_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).strength(4.0f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block STRIPPED_SPONGE_WOOD = registerBlock("stripped_sponge_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4.0f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block SPONGE_PLANKS = registerBlock("sponge_planks",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(2.0f).requiresTool()), ModItemGroup.CHEESY_SPONGE);
    public static final Block SPONGE_LEAVES = registerBlock("sponge_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).strength(2.0f).requiresTool().nonOpaque()), ModItemGroup.CHEESY_SPONGE);
    public static final Block SPONGE_SAPLING = registerBlock("sponge_sapling",
            new ModSaplingBlock(new SpongeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING).strength(2.0f).requiresTool().nonOpaque()), ModItemGroup.CHEESY_SPONGE);
    public static final Block CHEESE_BLASTER = registerBlock("cheese_blaster",
            new CheeseBlasterBlock(FabricBlockSettings.copy(Blocks.FURNACE).strength(2.0f).requiresTool().nonOpaque()), ModItemGroup.CHEESY_SPONGE);

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
    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group){
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
