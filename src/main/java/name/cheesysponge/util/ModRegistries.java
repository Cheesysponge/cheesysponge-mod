package name.cheesysponge.util;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.command.ReturnHomeCommand;
import name.cheesysponge.command.SetHomeCommand;
import name.cheesysponge.entity.ModEntities;
import name.cheesysponge.entity.custom.CheeseBirdEntity;
import name.cheesysponge.entity.custom.CheeseBossEntity;
import name.cheesysponge.entity.custom.CheeseEntity;
import name.cheesysponge.event.ModPlayerEventCopyFrom;
import name.cheesysponge.item.ModItems;
import name.cheesysponge.villager.ModVillagers;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
        registerCommands();
        registerEvents();
        registerStrippables();
        registerFlammableBlock();
        registerCustomTrades();
        registerAttributes();

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

        registry.add(ModItems.BURNING_CHEESE, 20000);
    }
    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }


    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.SPONGE,5),
                            new ItemStack(ModItems.SPONGE_SEEDS, 64),
                            6,102,0.02f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 60),
                            new ItemStack(ModItems.CHEESY_SPONGE_PICKAXE, 1),
                            2,17,0.09f));
                });


        TradeOfferHelper.registerVillagerOffers(ModVillagers.BLAST_MASTER,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModItems.BURNING_CHEESE, 1),
                            12,1,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            new ItemStack(Items.SPONGE, 1),
                            12,2,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SPONGE_INGOT, 3),
                            new ItemStack(ModItems.BURNING_CHEESE,2),
                            new ItemStack(ModItems.CHEESY_SPONGE, 1),
                            12,3,0.08f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BLAST_MASTER,2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModBlocks.CHEESYSPONGE_BLOCK, 1),
                            new ItemStack(ModItems.HYPE_MUSIC_DISC, 1),
                            12,7,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EGG, 16),
                            new ItemStack(ModBlocks.CHEESYSPONGE_BLOCK, 64),
                            new ItemStack(ModItems.CHEESE_SPAWN_EGG, 64),
                            12,7,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK, 64),
                            new ItemStack(ModBlocks.CHEESYSPONGE_BLOCK,64),
                            new ItemStack(ModItems.CHEESE_GUN, 1),
                            12,7,0.08f));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.BLAST_MASTER,3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SPONGE_SEEDS, 4),
                            new ItemStack(ModItems.SPONGE_INGOT, 4),
                            12,7,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HYPE_MUSIC_DISC, 1),
                            new ItemStack(ModBlocks.CHEESYSPONGE_BLOCK, 1),
                            12,7,0.08f));
                });
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.CHEESE, CheeseEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CHEESE_BOSS, CheeseBossEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CHEESE_BIRD, CheeseBirdEntity.setAttributes());
    }


}