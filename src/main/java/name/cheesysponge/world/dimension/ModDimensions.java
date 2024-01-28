package name.cheesysponge.world.dimension;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.item.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> CHEESEDIM_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(SpongeMod.MOD_ID, "cheesedim"));
    public static final RegistryKey<DimensionType> CHEESEDIM_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CHEESEDIM_DIMENSION_KEY.getValue());

    public static void register(){
        SpongeMod.LOGGER.debug("😀 Registering ModDimensions for " + SpongeMod.MOD_ID + "!!!!!");
        CustomPortalBuilder.beginPortal().frameBlock(ModBlocks.SPONGE_LEAVES)
                .destDimID(CHEESEDIM_DIMENSION_KEY.getValue())
                .tintColor(227, 207, 30)
                .lightWithItem(ModItems.CHEESY_SPONGE_STAFF)
                .onlyLightInOverworld()
                .registerPortal();
    }

}