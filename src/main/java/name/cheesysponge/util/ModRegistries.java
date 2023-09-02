package name.cheesysponge.util;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.command.ReturnHomeCommand;
import name.cheesysponge.command.SetHomeCommand;
import name.cheesysponge.event.ModPlayerEventCopyFrom;
import name.cheesysponge.item.ModItems;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
        registerCommands();
        registerEvents();
        registerStrippables();
        registerFlammableBlock();
        registerCustomTrades();

    }


    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.SPONGE_LOG, ModBlocks.STRIPPED_SPONGE_LOG);
        StrippableBlockRegistry.register(ModBlocks.SPONGE_WOOD, ModBlocks.STRIPPED_SPONGE_WOOD);
    }

    private static void registerFlammableBlock() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.SPONGE_LOG, 1, 1);
        instance.add(ModBlocks. STRIPPED_SPONGE_LOG, 1, 1);
        instance.add(ModBlocks.SPONGE_WOOD, 1, 1);
        instance.add(ModBlocks.STRIPPED_SPONGE_WOOD, 1, 1);
        instance.add(ModBlocks.SPONGE_PLANKS, 1, 4);
        instance.add(ModBlocks.SPONGE_LEAVES, 6, 12);
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


    private static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers();
    }

}
