package name.cheesysponge.datagen;

import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.ArrayList;
import java.util.Collection;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.END_PURE_CHEESE_ORE, dropsWithSilkTouch(ModBlocks.END_PURE_CHEESE_ORE, this.applyExplosionDecay(ModBlocks.END_PURE_CHEESE_ORE, ItemEntry.builder(ModItems.PURE_CHEESE).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 2.0F))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))));    }
}