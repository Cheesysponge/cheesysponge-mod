package name.cheesysponge.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;

public class LightningStrikerEnchantment extends Enchantment {
    protected LightningStrikerEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()){
            ServerWorld world = (ServerWorld)user.world;
            BlockPos position = target.getBlockPos();

            if(level == 1){
                target.pushAwayFrom(target);

                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,100,1));
            }

            if(level == 2){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,200,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,100,1));
            }
            if(level == 3){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,400,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,200,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE,100,1));
            }
            if(level == 4){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,800,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,400,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE,200,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,100,1));
            }
            if(level == 5) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,1600,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,800,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE,400,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,100,1));
                EntityType.EVOKER_FANGS.spawn(world,null,null,null,position, SpawnReason.TRIGGERED,true,true);
            }
            if(level == 6) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,3200,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,1600,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE,800,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,400,3));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,200,1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,100,1));
                EntityType.EVOKER_FANGS.spawn(world,null,null,null,position, SpawnReason.TRIGGERED,true,true);
                EntityType.EVOKER_FANGS.spawn(world,null,null,null,position, SpawnReason.TRIGGERED,true,true);
            }


        }
    }

    @Override
    public int getMaxLevel() {
        return 6;
    }
}
