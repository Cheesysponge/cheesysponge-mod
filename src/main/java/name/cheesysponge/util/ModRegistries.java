package name.cheesysponge.util;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();

    }

    private static void registerFuels() {
        SpongeMod.LOGGER.info("Registering Fuels for " + SpongeMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.BURNING_CHEESE, 200000);
    }



}
