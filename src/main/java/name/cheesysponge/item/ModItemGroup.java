package name.cheesysponge.item;

import name.cheesysponge.SpongeMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup CHEESY_SPONGE = FabricItemGroup.builder(new Identifier(SpongeMod.MOD_ID, "cheesy_sponge"))
            .displayName(Text.literal("Cheese & Sponges"))
            .icon(() -> new ItemStack(ModItems.CHEESY_SPONGE)).build();;
}
