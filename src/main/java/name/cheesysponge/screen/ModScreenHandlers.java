package name.cheesysponge.screen;

import name.cheesysponge.SpongeMod;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<CheeseBlasterScreenHandler> CHEESE_BLASTER_SCREEN_HANDLER;



    public static void registerAllScreenHandlers() {
        CHEESE_BLASTER_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(SpongeMod.MOD_ID, "cheese_blaster"),
                        CheeseBlasterScreenHandler::new);
    }
}