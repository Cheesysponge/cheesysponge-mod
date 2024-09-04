package name.cheesysponge.fluid;

import name.cheesysponge.SpongeMod;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid CHEESE_STILL = register("cheese_still", new CheeseFluid.Still());
    public static final FlowableFluid CHEESE_FLOWING = register("cheese_flowing", new CheeseFluid.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registry.FLUID, new Identifier(SpongeMod.MOD_ID, name), flowableFluid);
    }
}
