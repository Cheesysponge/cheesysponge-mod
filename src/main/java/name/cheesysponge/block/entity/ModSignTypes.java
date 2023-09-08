package name.cheesysponge.block.entity;

import name.cheesysponge.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class ModSignTypes {
    public static final SignType SPONGE_WOOD =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("sponge_wood"));
}