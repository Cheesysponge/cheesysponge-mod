package name.cheesysponge.world.gen;

import name.cheesysponge.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SPONGE_TREE_PLACED_KEY);
    }
}