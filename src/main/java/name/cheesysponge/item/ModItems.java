package name.cheesysponge.item;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.entity.ModEntities;
import name.cheesysponge.fluid.ModFluids;
import name.cheesysponge.item.custom.*;
import name.cheesysponge.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

import net.minecraft.util.Rarity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item SPONGE_INGOT = registerItem("sponge_ingot", new Item(new FabricItemSettings().food(ModFoodComponents.SPONGE_CLUMP)));
    public static final Item CHEESY_SPONGE = registerItem("cheesy_sponge", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(12)));
    public static final Item RAW_CHEESY_SPONGE = registerItem("raw_cheesy_sponge", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(12)));
    public static final Item CHEESY_SPONGE_ROD = registerItem("cheesy_sponge_rod", new SpongeRodItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1).maxDamage(400)));
    public static final Item BURNING_CHEESE = registerItem("burning_cheese", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(5).food(ModFoodComponents.BURNING_CHEESE)));
    public static final Item CHEESY_SPONGE_SWORD = registerItem("cheesy_sponge_sword", new SwordItem(ModToolMaterials.CHEESYSPONGE,3,-2.3f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESY_SPONGE_AXE = registerItem("cheesy_sponge_axe", new ModAxeItem(ModToolMaterials.CHEESYSPONGE,6,-2.9f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));

    public static final Item CHEESY_SPONGE_PICKAXE = registerItem("cheesy_sponge_pickaxe", new ModPickaxeItem(ModToolMaterials.CHEESYSPONGE,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));

    public static final Item CHEESY_SPONGE_HOE = registerItem("cheesy_sponge_hoe", new ModHoeItem(ModToolMaterials.CHEESYSPONGE,3,20f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESY_SPONGE_SHOVEL = registerItem("cheesy_sponge_shovel", new ShovelItem(ModToolMaterials.CHEESYSPONGE,14,-3.5f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESY_SPONGE_MAGIC_SWORD = registerItem("cheesy_sponge_magic_sword", new ModSlownessSwordItem(ModToolMaterials.CHEESYSPONGE,4,-2.3f,new FabricItemSettings().rarity(Rarity.EPIC).fireproof().maxCount(1)));

    public static final Item CHEESY_SPONGE_HELMET = registerItem("cheesy_sponge_helmet", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, ArmorItem.Type.HELMET,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESY_SPONGE_CHESTPLATE = registerItem("cheesy_sponge_chestplate", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, ArmorItem.Type.CHESTPLATE,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESY_SPONGE_LEGGINGS = registerItem("cheesy_sponge_leggings", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, ArmorItem.Type.LEGGINGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESY_SPONGE_BOOTS = registerItem("cheesy_sponge_boots", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, ArmorItem.Type.BOOTS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item DATA_TABLET = registerItem("data_tablet", new DataTabletItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item SPONGE_HELMET = registerItem("sponge_helmet", new ModArmorItem(ModArmorMaterials.SPONGE, ArmorItem.Type.HELMET,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item SPONGE_CHESTPLATE = registerItem("sponge_chestplate", new ModArmorItem(ModArmorMaterials.SPONGE, ArmorItem.Type.CHESTPLATE,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item SPONGE_LEGGINGS = registerItem("sponge_leggings", new ModArmorItem(ModArmorMaterials.SPONGE, ArmorItem.Type.LEGGINGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item SPONGE_BOOTS = registerItem("sponge_boots", new ModArmorItem(ModArmorMaterials.SPONGE, ArmorItem.Type.BOOTS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESE_HELMET = registerItem("cheese_helmet", new ModArmorItem(ModArmorMaterials.CHEESE, ArmorItem.Type.HELMET,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESE_CHESTPLATE = registerItem("cheese_chestplate", new ModArmorItem(ModArmorMaterials.CHEESE, ArmorItem.Type.CHESTPLATE,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESE_LEGGINGS = registerItem("cheese_leggings", new ModArmorItem(ModArmorMaterials.CHEESE, ArmorItem.Type.LEGGINGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item CHEESE_BOOTS = registerItem("cheese_boots", new ModArmorItem(ModArmorMaterials.CHEESE, ArmorItem.Type.BOOTS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));
    public static final Item SPONGE_SEEDS = registerItem("sponge_seeds", new AliasedBlockItem(ModBlocks.SPONGE_WEED, new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static final Item CHEESE_BOW = registerItem("cheese_bow", new CheeseBowItem(new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1).maxDamage(600)));
    public static final Item HYPE_MUSIC_DISC = registerItem("hype_music_disc", new ModMusicDiscItem(7, ModSounds.HYPE_MUSIC,new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxDamage(1000),147));
    public static final Item CHEESY_SPONGE_STAFF = registerItem("cheesy_sponge_staff", new ModSlownessSwordItem(ModToolMaterials.CHEESYSPONGE,4,-2.3f,new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));

    public static final Item CHEESE_BUCKET = registerItem("cheese_bucket",
            new BucketItem(ModFluids.CHEESE_STILL, new FabricItemSettings().maxCount(1).food(ModFoodComponents.LIQUID_CHEESE)));
    public static final Item CHEESE_GUN = registerItem("cheese_gun",
            new CheeseGunItem(new FabricItemSettings().maxCount(1)));

    public static final Item CHEESE_SPAWN_EGG = registerItem("cheese_spawn_egg",
            new SpawnEggItem(ModEntities.CHEESE,0xe2ff3d, 0xfcba03,
                    new FabricItemSettings().maxCount(64)));
    public static final Item CHEESE_BOSS_SPAWN_EGG = registerItem("cheese_boss_spawn_egg",
            new SpawnEggItem(ModEntities.CHEESE_BOSS,0xffc524, 0xdeff24,
                    new FabricItemSettings().maxCount(64)));
    public static final Item CHEESE_BIRD_SPAWN_EGG = registerItem("cheese_bird_spawn_egg",
            new SpawnEggItem(ModEntities.CHEESE_BIRD,0xffbd24, 0x7a5a00,
                    new FabricItemSettings().maxCount(64)));
    public static final Item INVISIBLE_SHIELD = registerItem("invisible_shield", new ShieldItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1).maxDamage(1400)));

    private static Item registerItem(String name, Item item) {
        addToItemGroup(ModItemGroup.CHEESY_SPONGE,item);
        return Registry.register(Registries.ITEM, new Identifier(SpongeMod.MOD_ID, name), item);
    }
    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        SpongeMod.LOGGER.info("Registering Mod Items for " + SpongeMod.MOD_ID);
    }
}
