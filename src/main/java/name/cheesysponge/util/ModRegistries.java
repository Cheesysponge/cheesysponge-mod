package name.cheesysponge.util;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.command.ReturnHomeCommand;
import name.cheesysponge.command.SetHomeCommand;
import name.cheesysponge.event.ModPlayerEventCopyFrom;
import name.cheesysponge.item.ModItems;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
        registerCommands();
        registerEvents();

    }

    private static void registerFuels() {
        SpongeMod.LOGGER.info("Registering Fuels for " + SpongeMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.BURNING_CHEESE, 200000);
    }
    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }




}
