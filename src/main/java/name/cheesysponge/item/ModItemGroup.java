package name.cheesysponge.item;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup CHEESY_SPONGE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SpongeMod.MOD_ID, "cheesy_sponge"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.cheesysponge.cheesy_sponge"))
                    .icon(() -> new ItemStack(ModItems.CHEESY_SPONGE)).entries((displayContext, entries) -> {
                        for(int i = 0; i<ModItems.items.length;i++){
                            entries.add(ModItems.items[i]);
                        }
                        for(int i = 0; i< ModBlocks.blocks.length; i++){
                            entries.add(ModBlocks.blocks[i]);
                        }
                    }).build());

    public static void registerItemGroups() {
        SpongeMod.LOGGER.info("Registering Item Groups for " + SpongeMod.MOD_ID);
    }
}
