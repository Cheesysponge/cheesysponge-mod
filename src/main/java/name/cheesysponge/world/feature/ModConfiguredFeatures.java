package name.cheesysponge.world.feature;

import name.cheesysponge.SpongeMod;

import name.cheesysponge.block.ModBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    private static Object ModBlocks;
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> SPONGE_TREE =
            ConfiguredFeatures.register("sponge_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(name.cheesysponge.block.ModBlocks.SPONGE_LOG),
                    new StraightTrunkPlacer(5, 8, 3),
                    BlockStateProvider.of(name.cheesysponge.block.ModBlocks.SPONGE_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(4, 0, 4)).build());

    public static final RegistryEntry<PlacedFeature> SPONGE_CHECKED =
            PlacedFeatures.register("sponge_checked", SPONGE_TREE,
                    PlacedFeatures.wouldSurvive(name.cheesysponge.block.ModBlocks.SPONGE_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> SPONGE_SPAWN =
            ConfiguredFeatures.register("sponge_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(SPONGE_CHECKED, 0.5f)),
                            SPONGE_CHECKED));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CHEESY_SPONGE_FLOWER =
            ConfiguredFeatures.register("cheesy_sponge_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(name.cheesysponge.block.ModBlocks.CHEESY_SPONGE_FLOWER)))));


    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + SpongeMod.MOD_ID);
    }
}