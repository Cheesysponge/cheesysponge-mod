package name.cheesysponge.world.feature;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

import static name.cheesysponge.world.feature.ModOreFeatures.modifiersWithCount;

public class ModPlacedFeatures {



    public static final RegistryKey<PlacedFeature> SPONGE_TREE_PLACED_KEY = registerKey("sponge_tree");
    public static final RegistryKey<PlacedFeature> SPONGE_TREE_CHECKED_KEY = registerKey("sponge_tree_placed");

    public static final RegistryKey<PlacedFeature> CHEESY_SPONGE_FLOWER_PLACED_KEY = registerKey("cheesy_sponge_flower_placed");

    public static final RegistryKey<PlacedFeature> CHEESYSPONGE_ORE_PLACED_KEY = registerKey("cheesysponge_ore_placed");

    public static final RegistryKey<PlacedFeature> NETHER_CHEESYSPONGE_ORE_PLACED_KEY = registerKey("nether_cheesysponge_ore_placed");

    public static final RegistryKey<PlacedFeature> END_CHEESYSPONGE_ORE_PLACED_KEY = registerKey("end_cheesysponge_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SPONGE_TREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPONGE_TREE_KEY),
                List.of(net.minecraft.world.gen.feature.PlacedFeatures.wouldSurvive(ModBlocks.SPONGE_SAPLING)));
        register(context, SPONGE_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPONGE_TREE_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

        register(context, CHEESYSPONGE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHEESYSPONGE_ORE_KEY),
                modifiersWithCount(16, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
        register(context, NETHER_CHEESYSPONGE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_CHEESYSPONGE_ORE_KEY),
                modifiersWithCount(16, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
        register(context, END_CHEESYSPONGE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_CHEESYSPONGE_ORE_KEY),
                modifiersWithCount(16, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));



        register(context, CHEESY_SPONGE_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHEESY_SPONGE_FLOWER_KEY),
                RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }




//    public static final RegistryEntry<PlacedFeature> SPONGE_PLACED = PlacedFeatures.register("sponge_placed",
//            ModConfiguredFeatures.SPONGE_SPAWN, VegetationPlacedFeatures.modifiers(
//                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
//    public static final RegistryEntry<PlacedFeature> CHEESY_SPONGE_FLOWER_PLACED = PlacedFeatures.register("cheesy_sponge_flower_placed",
//            ModConfiguredFeatures.CHEESY_SPONGE_FLOWER, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
//            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
//    public static final RegistryEntry<PlacedFeature> CHEESYSPONGE_ORE_PLACED = PlacedFeatures.register("cheesysponge_ore_placed",
//            ModConfiguredFeatures.CHEESYSPONGE_ORE, ModOreFeatures.modifiersWithCount(4,//veins per chunk
//                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-60), YOffset.aboveBottom(80))));
//
//    public static final RegistryEntry<PlacedFeature> NETHER_CHEESYSPONGE_ORE_PLACED = PlacedFeatures.register("nether_cheesysponge_ore_placed",
//            ModConfiguredFeatures.NETHER_CHEESYSPONGE_ORE, ModOreFeatures.modifiersWithCount(5,//veins per chunk
//                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-20), YOffset.aboveBottom(120))));
//
//    public static final RegistryEntry<PlacedFeature> END_CHEESYSPONGE_ORE_PLACED = PlacedFeatures.register("end_cheesysponge_ore_placed",
//            ModConfiguredFeatures.END_, ModOreFeatures.modifiersWithCount(6,//veins per chunk
//                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-10), YOffset.aboveBottom(100))));

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SpongeMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}