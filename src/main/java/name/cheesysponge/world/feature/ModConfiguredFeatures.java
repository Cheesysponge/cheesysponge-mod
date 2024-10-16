package name.cheesysponge.world.feature;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SpongeMod.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    public static final RegistryKey<ConfiguredFeature<?,?>> SPONGE_TREE_KEY = registerKey("sponge_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> SPONGE_TREE_SPAWN_KEY = registerKey("sponge_tree_spawn");

    public static final RegistryKey<ConfiguredFeature<?,?>> CHEESY_SPONGE_FLOWER_KEY = registerKey("cheesy_sponge_tree");

    public static final RegistryKey<ConfiguredFeature<?,?>> CHEESYSPONGE_ORE_KEY = registerKey("cheesysponge_ore");

    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_CHEESYSPONGE_ORE_KEY = registerKey("nether_cheesysponge_ore");

    public static final RegistryKey<ConfiguredFeature<?,?>> END_CHEESYSPONGE_ORE_KEY = registerKey("end_cheesysponge_ore");

//    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> SPONGE_TREE =
//            ConfiguredFeatures.register("sponge_tree", Feature.TREE, new TreeFeatureConfig.Builder(
//                    BlockStateProvider.of(name.cheesysponge.block.ModBlocks.SPONGE_LOG),
//                    new StraightTrunkPlacer(5, 8, 3),
//                    BlockStateProvider.of(name.cheesysponge.block.ModBlocks.SPONGE_LEAVES),
//                    new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 4),
//                    new TwoLayersFeatureSize(4, 0, 4)).build());
//
//    public static final RegistryEntry<PlacedFeature> SPONGE_CHECKED =
//            PlacedFeatures.register("sponge_checked", SPONGE_TREE,
//                    PlacedFeatures.wouldSurvive(name.cheesysponge.block.ModBlocks.SPONGE_SAPLING));
//
//    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> SPONGE_SPAWN =
//            ConfiguredFeatures.register("sponge_spawn", Feature.RANDOM_SELECTOR,
//                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(SPONGE_CHECKED, 0.5f)),
//                            SPONGE_CHECKED));
//    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CHEESY_SPONGE_FLOWER =
//            ConfiguredFeatures.register("cheesy_sponge_flower", Feature.FLOWER,
//                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
//                            new SimpleBlockFeatureConfig(BlockStateProvider.of(name.cheesysponge.block.ModBlocks.CHEESY_SPONGE_FLOWER)))));
//
//            ConfiguredFeatures.register(featureRegisterable, ORE_IRON, Feature.ORE, new OreFeatureConfig(list, 9));

    public static final List<OreFeatureConfig.Target> OVERWORLD_CHEESYSPONGE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.STONE),
                    name.cheesysponge.block.ModBlocks.CHEESYSPONGE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DEEPSLATE),
                    name.cheesysponge.block.ModBlocks.DEEPSLATE_CHEESYSPONGE_ORE.getDefaultState()));

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldCheesyspongeOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.CHEESYSPONGE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_CHEESYSPONGE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherCheesyspongeOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_CHEESYSPONGE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endCheesyspongeOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ModBlocks.END_CHEESYSPONGE_ORE.getDefaultState()));

        register(context, SPONGE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SPONGE_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.SPONGE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SPONGE_TREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.SPONGE_TREE_PLACED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.SPONGE_TREE_PLACED_KEY)));

        register(context, CHEESYSPONGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldCheesyspongeOres, 12));
        register(context, NETHER_CHEESYSPONGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCheesyspongeOres, 12));
        register(context, END_CHEESYSPONGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCheesyspongeOres, 12));



        register(context, CHEESY_SPONGE_FLOWER_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CHEESY_SPONGE_FLOWER)))));
    }

//    public static final List<OreFeatureConfig.Target> NETHER_CHEESYSPONGE_ORES = List.of(
//            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK),
//                    name.cheesysponge.block.ModBlocks.NETHER_CHEESYSPONGE_ORE.getDefaultState()));
//    public static final List<OreFeatureConfig.Target> END_CHEESYSPONGE_ORES = List.of(
//            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE),
//                    name.cheesysponge.block.ModBlocks.END_CHEESYSPONGE_ORE.getDefaultState()));
//
//    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CHEESYSPONGE_ORE =
//            ConfiguredFeatures.register("cheesysponge_ore",Feature.ORE,
//                    new OreFeatureConfig(OVERWORLD_CHEESYSPONGE_ORES, 6, 0.5f));
//
//
//    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_CHEESYSPONGE_ORE =
//            ConfiguredFeatures.register(,NETHER_CHEESYSPONGE_ORES,Feature.ORE,
//                    new OreFeatureConfig(NETHER_CHEESYSPONGE_ORES, 5, 0.5f));
//
//    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_CHEESYSPONGE_ORE =
//            ConfiguredFeatures.register("end_cheesysponge_ore",Feature.ORE,
//                    new OreFeatureConfig(END_CHEESYSPONGE_ORES, 5, 0.5f));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + SpongeMod.MOD_ID);
    }
}