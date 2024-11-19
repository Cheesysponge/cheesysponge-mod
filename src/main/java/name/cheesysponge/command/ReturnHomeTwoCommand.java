package name.cheesysponge.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import name.cheesysponge.util.IEntityDataSaver;
import name.cheesysponge.world.dimension.ModDimensions;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class ReturnHomeTwoCommand {
    private static final SimpleCommandExceptionType INVALID_POSITION_EXCEPTION = new SimpleCommandExceptionType(
            Text.translatable("commands.teleport.invalidPosition")
    );
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("homereturn")
                .then(CommandManager.literal("1").executes(ReturnHomeTwoCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver) context.getSource().getPlayer();

        // not 0 means it contains SOMETHING
        assert player != null;
        int[] homepos = player.getPersistentData().getIntArray("homepose");

        int[] playerPos = player.getPersistentData().getIntArray("homepose");
        RegistryKey<World> world = context.getSource().getWorld().getRegistryKey();
        if(playerPos[3] == 1){
            world = World.OVERWORLD;
        }
        if(playerPos[3] == 2){
            world = World.NETHER;
        }
        if(playerPos[3] == 3){
            world = World.END;
        }
        if(playerPos[3] == 4){
            world = ModDimensions.CHEESEDIM_DIMENSION_KEY;
        }
        if (homepos.length != 0) {
            context.getSource().getPlayer().teleport(context.getSource().getServer().getWorld(world),playerPos[0], playerPos[1], playerPos[2], 0f,0);

            context.getSource().getPlayer().sendMessage(Text.literal("Player returned Home!"), true);
            return 1;
        } else {
            //throw INVALID_POSITION_EXCEPTION.create();

            context.getSource().getPlayer().sendMessage( Text.literal("No Home Position has been Set!"), true);
            return -1;
        }
    }
}