package name.cheesysponge.entity;

import name.cheesysponge.SpongeMod;
import name.cheesysponge.entity.custom.CheeseBossEntity;
import name.cheesysponge.entity.custom.CheeseEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<CheeseEntity> CHEESE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(SpongeMod.MOD_ID, "cheese"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CheeseEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 0.7f)).build());
    public static final EntityType<CheeseBossEntity> CHEESE_BOSS = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(SpongeMod.MOD_ID, "cheese_boss"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CheeseBossEntity::new)
                    .dimensions(EntityDimensions.fixed(1.0f, 0.7f)).build());
}