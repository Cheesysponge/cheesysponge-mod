package name.cheesysponge.villager;

import com.google.common.collect.ImmutableSet;
import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType BLASTER_POI = registerPOI("blasterpoi", ModBlocks.CHEESE_BLASTER);
    public static final VillagerProfession BLAST_MASTER = registerProfession("blastmaster", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(SpongeMod.MOD_ID, "blasterpoi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(SpongeMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(SpongeMod.MOD_ID, name)).workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());

    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(SpongeMod.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers() {
        SpongeMod.LOGGER.debug("Registering Villagers for " + SpongeMod.MOD_ID);
    }
}