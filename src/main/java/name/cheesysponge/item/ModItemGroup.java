package name.cheesysponge.item;

import name.cheesysponge.SpongeMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CHEESY_SPONGE = FabricItemGroupBuilder.build(new Identifier(SpongeMod.MOD_ID, "cheesy_sponge"),
            () -> new ItemStack(ModItems.CHEESY_SPONGE));
}
