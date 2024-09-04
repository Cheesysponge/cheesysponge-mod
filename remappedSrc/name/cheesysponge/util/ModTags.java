package name.cheesysponge.util;

import name.cheesysponge.SpongeMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name){
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(SpongeMod.MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name){
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }

    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(SpongeMod.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }
}
