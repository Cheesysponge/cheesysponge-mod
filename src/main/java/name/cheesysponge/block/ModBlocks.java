package name.cheesysponge.block;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.custom.*;
import name.cheesysponge.fluid.ModFluids;
import name.cheesysponge.item.ModFoodComponents;
import name.cheesysponge.item.ModItemGroup;
import name.cheesysponge.sound.ModSounds;

import name.cheesysponge.world.feature.tree.SpongeSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;


import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

public class ModBlocks {

    public static final Block CHEESYSPONGE_BLOCK = registerBlock("cheesysponge_block",
            new Block(FabricBlockSettings.copy(Blocks.SPONGE).strength(8f).requiresTool().luminance((state) -> 16)), "tooltip.cheesysponge.cheesysponge_block");
    public static final Block CHEESYSPONGE_ORE = registerBlock("cheesysponge_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(4f).requiresTool().luminance((state) -> 16), UniformIntProvider.create(2,6)));
    public static final Block DEEPSLATE_CHEESYSPONGE_ORE = registerBlock("deepslate_cheesysponge_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(4f).requiresTool().luminance((state) -> 16), UniformIntProvider.create(2,6)));
    public static final Block END_CHEESYSPONGE_ORE = registerBlock("end_cheesysponge_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(4f).requiresTool().luminance((state) -> 16), UniformIntProvider.create(2,6)));
    public static final Block END_PURE_CHEESE_ORE = registerBlock("end_pure_cheese_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(4f).requiresTool().luminance((state) -> 0), UniformIntProvider.create(4,8)));
    public static final Block NETHER_CHEESYSPONGE_ORE = registerBlock("nether_cheesysponge_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(4f).requiresTool().luminance((state) -> 16), UniformIntProvider.create(2,6)));
    public static final Block CHEESY_BLOCK = registerBlock("cheesy_block",
            new CheesyBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(4f).requiresTool().luminance((state) -> 16)));
    public static final Block CHEESY_SPONGE_BUTTON = registerBlock("cheesy_sponge_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(1f).requiresTool().luminance((state) -> 16),new BlockSetType("cheesy_sponge_button"
            ),10,false));
    public static final Block CHEESY_SPONGE_PRESSURE_PLATE = registerBlock("cheesy_sponge_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING ,FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().luminance((state) -> 16),
                    new BlockSetType("cheesy_sponge_button"
                    )));
    public static final Block CHEESY_SPONGE_FENCE = registerBlock("cheesy_sponge_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().luminance((state) -> 16)));
    public static final Block CHEESY_SPONGE_FENCE_GATE = registerBlock("cheesy_sponge_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().luminance((state) -> 16), new WoodType("Sponge",
                    new BlockSetType("cheesy_sponge_button"
                    ))));
    public static final Block CHEESY_SPONGE_WALL = registerBlock("cheesy_sponge_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().luminance((state) -> 16)));

    public static final Block CHEESY_SPONGE_SLAB = registerBlock("cheesy_sponge_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().luminance((state) -> 16)));
    public static final Block CHEESY_SPONGE_STAIRS = registerBlock("cheesy_sponge_stairs",
            new StairsBlock(ModBlocks.CHEESYSPONGE_BLOCK.getDefaultState(), FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().luminance((state) -> 16)));
    public static final Block CHEESY_SPONGE_DOOR = registerBlock("cheesy_sponge_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().luminance((state) -> 16).nonOpaque(),
                    new BlockSetType("cheesy_sponge_button"
                    )));
    public static final Block CHEESY_SPONGE_TRAPDOOR = registerBlock("cheesy_sponge_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(3f).requiresTool().nonOpaque().luminance((state) -> 16),
                    new BlockSetType("cheesy_sponge_button"
                    )));
    public static final Block CHEESY_SPONGE_FLOWER = registerBlock("cheesy_sponge_flower",
            new FlowerBlock(StatusEffects.HEALTH_BOOST,1000,FabricBlockSettings.copy(Blocks.DANDELION).strength(3f).nonOpaque().requiresTool()));
    public static final Block POTTED_CHEESY_SPONGE_FLOWER = registerBlockWithoutBlockItem("potted_cheesy_sponge_flower",
            new FlowerPotBlock(ModBlocks.CHEESY_SPONGE_FLOWER,FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block CHEESY_SPONGE_LAMP = registerBlock("cheesy_sponge_lamp",
            new CheesySpongeLampBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(8f).requiresTool().sounds(ModSounds.CHEESY_SPONGE_SOUNDS).luminance((state) -> state.get(CheesySpongeLampBlock.CLICKED) ? 15 : 0)));
    public static final Block CHEESY_SPONGE_GLASS = registerBlock("cheesy_sponge_glass",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(3f).nonOpaque()));
    public static final Block SPONGE_WEED = registerBlockWithoutBlockItem("sponge_weed",
            new SpongeWeedBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));
    public static final Block SPONGE_LOG = registerBlock("sponge_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4.0f).requiresTool()));
    public static final Block CHEESE_BOX = registerBlock("cheese_box",
            new ModShulkerBox(FabricBlockSettings.copy(Blocks.SHULKER_BOX).strength(4.0f).requiresTool()));
    public static final Block SPONGE_WOOD = registerBlock("sponge_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(4.0f).requiresTool()));
    public static final Block STRIPPED_SPONGE_LOG = registerBlock("stripped_sponge_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).strength(4.0f).requiresTool()));
    public static final Block STRIPPED_SPONGE_WOOD = registerBlock("stripped_sponge_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4.0f).requiresTool()));
    public static final Block SPONGE_PLANKS = registerBlock("sponge_planks",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(2.0f).requiresTool()));
    public static final Block SPONGE_LEAVES = registerBlock("sponge_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).strength(2.0f).requiresTool().nonOpaque()));
    public static final Block SPONGE_SAPLING = registerBlock("sponge_sapling",
            new ModSaplingBlock(new SpongeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING).strength(2.0f).requiresTool().nonOpaque()));
    public static final Block CHEESE_BLASTER = registerBlock("cheese_blaster",
            new CheeseBlasterBlock(FabricBlockSettings.copy(Blocks.SPONGE).strength(2.0f).requiresTool().nonOpaque()));
//    public static final Block SPONGE_WOOD_SIGN_BLOCK = registerBlockWithoutBlockItem("sponge_wood_sign",
//            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), SignBlock.SPONGE_WOOD));
//
//    public static final Block SPONGE_WOOD_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("sponge_wood_wall_sign",
//            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.SPONGE_WOOD));
public static final Block[] blocks = new Block[] {END_PURE_CHEESE_ORE,CHEESYSPONGE_BLOCK, CHEESYSPONGE_ORE, DEEPSLATE_CHEESYSPONGE_ORE, END_CHEESYSPONGE_ORE, NETHER_CHEESYSPONGE_ORE, CHEESY_BLOCK, CHEESY_SPONGE_BUTTON, CHEESY_SPONGE_PRESSURE_PLATE, CHEESY_SPONGE_FENCE, CHEESY_SPONGE_FENCE_GATE, CHEESY_SPONGE_WALL, CHEESY_SPONGE_SLAB, CHEESY_SPONGE_STAIRS, CHEESY_SPONGE_DOOR, CHEESY_SPONGE_TRAPDOOR, CHEESY_SPONGE_FLOWER, CHEESY_SPONGE_LAMP, CHEESY_SPONGE_GLASS, SPONGE_LOG, CHEESE_BOX, SPONGE_WOOD, STRIPPED_SPONGE_LOG, STRIPPED_SPONGE_WOOD, SPONGE_PLANKS, SPONGE_LEAVES, SPONGE_SAPLING, CHEESE_BLASTER};

    public static final Block CHEESE_FLUID_BLOCK = registerBlockWithoutBlockItem("cheese_fluid_block",
            new ModFluidBlock(ModFluids.CHEESE_STILL, FabricBlockSettings.copy(Blocks.WATER)
                    .noCollision().nonOpaque().dropsNothing()));



    private static Block registerBlock(String name, Block block, String tooltipKey) {

        registerBlockItem(name, block, tooltipKey);
        return Registry.register(Registries.BLOCK, new Identifier(SpongeMod.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, String tooltipKey) {
        //registerBlockItem(name, block , group);
        Item item = null;
        if(name.contains("chees")) {
            item = Registry.register(Registries.ITEM, new Identifier(SpongeMod.MOD_ID, name),
                    new BlockItem(block, new FabricItemSettings().food(ModFoodComponents.CHEESE)) {
                        @Override
                        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                            tooltip.add(Text.translatable(tooltipKey));
                        }
                    });
        }
        else {
            item = Registry.register(Registries.ITEM, new Identifier(SpongeMod.MOD_ID, name),
                    new BlockItem(block, new FabricItemSettings()) {
                        @Override
                        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                            tooltip.add(Text.translatable(tooltipKey));
                        }
                    });
        }
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SpongeMod.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(SpongeMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = null;
        if(name.contains("chees")) {
            item = Registry.register(Registries.ITEM, new Identifier(SpongeMod.MOD_ID, name),
                    new BlockItem(block, new FabricItemSettings().food(ModFoodComponents.CHEESE)));
        }
        else{
            item = Registry.register(Registries.ITEM, new Identifier(SpongeMod.MOD_ID, name),
                    new BlockItem(block, new FabricItemSettings()));
        }
        //ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        SpongeMod.LOGGER.info("Registering ModBlocks for " + SpongeMod.MOD_ID);
    }

}