package name.cheesysponge.world.dimension;

import name.cheesysponge.SpongeMod;
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
    }
}