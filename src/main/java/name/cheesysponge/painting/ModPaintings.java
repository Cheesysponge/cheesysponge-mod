package name.cheesysponge.painting;

import name.cheesysponge.SpongeMod;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings {
    public static final PaintingMotive MARATHON = registerPainting("modern", new PaintingMotive(16, 16));
    public static final PaintingMotive FAMILY = registerPainting("big_modern", new PaintingMotive(32, 32));

    private static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(SpongeMod.MOD_ID, name), paintingMotive);
    }

    public static void registerPaintings() {
        SpongeMod.LOGGER.info("Registering Paintings for " + SpongeMod.MOD_ID);
    }
}