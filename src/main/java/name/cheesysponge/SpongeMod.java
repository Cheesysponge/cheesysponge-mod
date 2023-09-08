package name.cheesysponge;

import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.block.entity.ModBlockEntities;
import name.cheesysponge.effect.ModEffects;
import name.cheesysponge.item.ModItems;
import name.cheesysponge.painting.ModPaintings;
import name.cheesysponge.particle.ModParticles;
import name.cheesysponge.potion.ModPotions;
import name.cheesysponge.recipe.ModRecipes;
import name.cheesysponge.screen.ModScreenHandlers;
import name.cheesysponge.screen.slot.ModResultSlot;
import name.cheesysponge.util.ModLootTableModifiers;
import name.cheesysponge.util.ModRegistries;
import name.cheesysponge.world.feature.ModConfiguredFeatures;
import name.cheesysponge.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class 	SpongeMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors. W
	public static final String MOD_ID = "cheesysponge";
    public static final Logger LOGGER = LoggerFactory.getLogger("cheesysponge");

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModPaintings.registerPaintings();

		ModRegistries.registerModStuffs();
		ModLootTableModifiers.modifyLootTables();
		ModWorldGen.generateModWorldGen();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModBlockEntities.registerAllBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();

		ModParticles.registerParticles();



	}
}