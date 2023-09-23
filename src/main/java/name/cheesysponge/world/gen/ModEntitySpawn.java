package name.cheesysponge.world.gen;

import name.cheesysponge.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;

import net.minecraft.entity.passive.TameableEntity;

import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS),
                SpawnGroup.CREATURE, ModEntities.CHEESE, 500, 2, 5);

        SpawnRestrictionAccessor.callRegister(ModEntities.CHEESE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TameableEntity::isValidNaturalSpawn);

    }
}