package name.cheesysponge.block.entity;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.block.entity.CheeseBlasterBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlockEntities {
    public static BlockEntityType<CheeseBlasterBlockEntity> CHEESE_BLASTER;

    public static void registerAllBlockEntities(){
        CHEESE_BLASTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(SpongeMod.MOD_ID, "cheese_blaster"),
                FabricBlockEntityTypeBuilder.create(CheeseBlasterBlockEntity::new,
                        ModBlocks.CHEESE_BLASTER).build(null));
    }
}