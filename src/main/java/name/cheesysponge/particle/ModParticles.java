package name.cheesysponge.particle;

import name.cheesysponge.SpongeMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModParticles {
    public static final DefaultParticleType CHEESE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(SpongeMod.MOD_ID, "cheese_particle"),
                CHEESE_PARTICLE);
    }
}