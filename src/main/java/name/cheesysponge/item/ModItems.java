package name.cheesysponge.item;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.item.custom.*;
import name.cheesysponge.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ModItems {
    public static final Item SPONGE_INGOT = registerItem("sponge_ingot", new Item(new FabricItemSettings().group(ModItemGroup.CHEESY_SPONGE)));
    public static final Item CHEESY_SPONGE = registerItem("cheesy_sponge", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(12)));
    public static final Item RAW_CHEESY_SPONGE = registerItem("raw_cheesy_sponge", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(12)));
    public static final Item CHEESY_SPONGE_ROD = registerItem("cheesy_sponge_rod", new SpongeRodItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1).maxDamage(200)));
    public static final Item BURNING_CHEESE = registerItem("burning_cheese", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(2).food(ModFoodComponents.BURNING_CHEESE)));
    public static final Item CHEESY_SPONGE_SWORD = registerItem("cheesy_sponge_sword", new SwordItem(ModToolMaterials.CHEESYSPONGE,4,-2.3f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item CHEESY_SPONGE_AXE = registerItem("cheesy_sponge_axe", new ModAxeItem(ModToolMaterials.CHEESYSPONGE,6,-2.9f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));

    public static final Item CHEESY_SPONGE_PICKAXE = registerItem("cheesy_sponge_pickaxe", new ModPickaxeItem(ModToolMaterials.CHEESYSPONGE,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));

    public static final Item CHEESY_SPONGE_HOE = registerItem("cheesy_sponge_hoe", new ModHoeItem(ModToolMaterials.CHEESYSPONGE,4,20f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item CHEESY_SPONGE_SHOVEL = registerItem("cheesy_sponge_shovel", new ShovelItem(ModToolMaterials.CHEESYSPONGE,1,-3f,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item CHEESY_SPONGE_MAGIC_SWORD = registerItem("cheesy_sponge_magic_sword", new ModSlownessSwordItem(ModToolMaterials.CHEESYSPONGE,4,-2.3f,new FabricItemSettings().rarity(Rarity.EPIC).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));

    public static final Item CHEESY_SPONGE_HELMET = registerItem("cheesy_sponge_helmet", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item CHEESY_SPONGE_CHESTPLATE = registerItem("cheesy_sponge_chestplate", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item CHEESY_SPONGE_LEGGINGS = registerItem("cheesy_sponge_leggings", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item CHEESY_SPONGE_BOOTS = registerItem("cheesy_sponge_boots", new ModArmorItem(ModArmorMaterials.CHEESY_SPONGE, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item DATA_TABLET = registerItem("data_tablet", new DataTabletItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE).maxCount(1)));
    public static final Item SPONGE_SEEDS = registerItem("sponge_seeds", new AliasedBlockItem(ModBlocks.SPONGE_WEED, new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.CHEESY_SPONGE)));
    public static final Item CHEESE_BOW = registerItem("cheese_bow", new CheeseBowItem(new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1).maxDamage(600).group(ModItemGroup.CHEESY_SPONGE)));
    public static final Item HYPE_MUSIC_DISC = registerItem("hype_music_disc", new ModMusicDiscItem(7, ModSounds.HYPE_MUSIC,new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxDamage(1000).group(ModItemGroup.CHEESY_SPONGE)));

    public static final Item CHEESY_SPONGE_STAFF = registerItem("cheesy_sponge_staff", new ModSlownessSwordItem(ModToolMaterials.CHEESYSPONGE,4,-2.3f,new  FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().maxCount(1).group(ModItemGroup.CHEESY_SPONGE)));
    public static final Item SPONGE_WOOD_SIGN = registerItem("sponge_wood_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.CHEESY_SPONGE).maxCount(16),
                    ModBlocks.SPONGE_WOOD_SIGN_BLOCK, ModBlocks.SPONGE_WOOD_WALL_SIGN_BLOCK));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SpongeMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        SpongeMod.LOGGER.info("Registering Mod Items for " + SpongeMod.MOD_ID);
    }
}
