package name.cheesysponge.painting;

import name.cheesysponge.SpongeMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModPaintings {
    public static final PaintingVariant MARATHON = registerPainting("modern", new PaintingVariant(16, 16));
    public static final PaintingVariant FAMILY = registerPainting("big_modern", new PaintingVariant(32, 32));

    private static PaintingVariant registerPainting(String name, PaintingVariant PaintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(SpongeMod.MOD_ID, name), PaintingVariant);
    }

    public static void registerPaintings() {
        SpongeMod.LOGGER.info("Registering Paintings for " + SpongeMod.MOD_ID);
    }
}