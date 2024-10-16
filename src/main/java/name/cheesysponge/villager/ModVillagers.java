package name.cheesysponge.villager;

import com.google.common.collect.ImmutableSet;
import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType BLASTER_POI = registerPOI("blasterpoi", ModBlocks.CHEESE_BLASTER);
    public static final VillagerProfession BLAST_MASTER = registerProfession("blastmaster", RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(SpongeMod.MOD_ID, "blasterpoi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(SpongeMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(SpongeMod.MOD_ID, name)).workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());

    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return Registry.register(Registries.POINT_OF_INTEREST_TYPE, new Identifier(SpongeMod.MOD_ID, name),
                new PointOfInterestType(ImmutableSet.copyOf(block.getStateManager().getStates()), 1, 1));
    }
    public static void registerVillagers() {
        SpongeMod.LOGGER.debug("Registering Villagers for " + SpongeMod.MOD_ID);
    }
}