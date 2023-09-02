package name.cheesysponge.world.gen;

import name.cheesysponge.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.all(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHEESY_SPONGE_FLOWER_PLACED.getKey().get());
    }
}