package name.cheesysponge.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import name.cheesysponge.util.IEntityDataSaver;
import name.cheesysponge.world.dimension.ModDimensions;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SetHomeTwoCommand {
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("homeset")
                .then(CommandManager.literal("1").executes(SetHomeTwoCommand::run)));
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
        BlockPos playerPos = context.getSource().getPlayer().getBlockPos();
        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";


        int n = 0;
        RegistryKey<World> world = context.getSource().getWorld().getRegistryKey();
        if(world == World.OVERWORLD){
            n = 1;
        } else if (world == World.NETHER) {
            n =2;
        }
        else if (world == World.END) {
            n =2;
        }
        else if (world == ModDimensions.CHEESEDIM_DIMENSION_KEY) {
            n =3;
        }
        assert player != null;
        player.getPersistentData().putIntArray("homepose",
                new int[] {playerPos.getX(), playerPos.getY(), playerPos.getZ(),n });

        context.getSource().getPlayer().sendMessage(Text.literal("Set home at " + pos), true);
        return 1;
    }
}