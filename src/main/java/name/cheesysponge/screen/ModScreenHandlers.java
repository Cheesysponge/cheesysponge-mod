package name.cheesysponge.screen;

import name.cheesysponge.SpongeMod;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlers {
    public static ScreenHandlerType<CheeseBlasterScreenHandler> CHEESE_BLASTER_SCREEN_HANDLER;
//    public static ScreenHandlerType<CheeseBlasterScreenHandler> CHEESE_BLASTER_SCREEN_HANDLER =
//            Registry.register(
//                    Registry.SCREEN_HANDLER,
//                    new Identifier(SpongeMod.MOD_ID, "cheese_blaster"),
//                    new ScreenHandlerType<>(CheeseBlasterScreenHandler::new)
//            );



    public static void registerAllScreenHandlers() {
        CHEESE_BLASTER_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(SpongeMod.MOD_ID, "cheese_blaster"),
                        CheeseBlasterScreenHandler::new);
    }
}