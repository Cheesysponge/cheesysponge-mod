package name.cheesysponge.block.entity;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.block.ModBlocks;
import name.cheesysponge.block.entity.CheeseBlasterBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<CheeseBlasterBlockEntity> CHEESE_BLASTER;
    public static BlockEntityType<CheeseBoxEntity> CHEESE_BOX;

    public static void registerAllBlockEntities(){
        CHEESE_BLASTER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(SpongeMod.MOD_ID, "cheese_blaster"),
                FabricBlockEntityTypeBuilder.create(CheeseBlasterBlockEntity::new,
                        ModBlocks.CHEESE_BLASTER).build(null));
        CHEESE_BOX = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(SpongeMod.MOD_ID, "cheese_box"),
                FabricBlockEntityTypeBuilder.create(CheeseBoxEntity::new,
                        ModBlocks.CHEESE_BOX).build(null));
    }
}