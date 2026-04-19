package dev.fayr.portalcalculator;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PortalCalculator120 implements ModInitializer {
    public static final String MOD_ID = "portal-calculator-120";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final int OW_XZ_MIN = -29999984;
    private static final int OW_XZ_MAX =  29999984;
    private static final int OW_Y_MIN  = -64;
    private static final int OW_Y_MAX  =  320;

    private static final int NT_XZ_MIN = -3749998;
    private static final int NT_XZ_MAX =  3749998;
    private static final int NT_Y_MIN  =  0;
    private static final int NT_Y_MAX  =  128;

    @Override
    public void onInitialize() {
        LOGGER.info("Portal Calculator loaded!");

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                Commands.literal("convert")
                    .requires(source -> true)
                    .executes(this::executeAutoConvert)
                    .then(Commands.literal("nether")
                        .then(Commands.argument("x", IntegerArgumentType.integer(OW_XZ_MIN, OW_XZ_MAX))
                        .then(Commands.argument("y", IntegerArgumentType.integer(OW_Y_MIN,  OW_Y_MAX))
                        .then(Commands.argument("z", IntegerArgumentType.integer(OW_XZ_MIN, OW_XZ_MAX))
                            .executes(this::executeToNether)
                        )))
                    )
                    .then(Commands.literal("overworld")
                        .then(Commands.argument("x", IntegerArgumentType.integer(NT_XZ_MIN, NT_XZ_MAX))
                        .then(Commands.argument("y", IntegerArgumentType.integer(NT_Y_MIN,  NT_Y_MAX))
                        .then(Commands.argument("z", IntegerArgumentType.integer(NT_XZ_MIN, NT_XZ_MAX))
                            .executes(this::executeToOverworld)
                        )))
                    )
            );
        });
    }

    private ServerPlayer getPlayer(CommandContext<CommandSourceStack> context) {
        return context.getSource().getPlayer();
    }

    private void sendMessage(ServerPlayer player, String message) {
        player.sendSystemMessage(Component.literal(message));
    }

    private long[] toNether(long x, long z) {
        return new long[]{ Math.round(x / 8.0), Math.round(z / 8.0) };
    }

    private long[] toOverworld(long x, long z) {
        return new long[]{ Math.round(x * 8.0), Math.round(z * 8.0) };
    }

    private int executeAutoConvert(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = getPlayer(context);
        if (player == null) return 0;
        Vec3 pos = player.position();
        String dimension = player.level().dimension().location().toString();
        long x = Math.round(pos.x);
        long y = Math.round(pos.y);
        long z = Math.round(pos.z);
        String message;
        if (dimension.equals("minecraft:overworld")) {
            long[] nether = toNether(x, z);
            message = String.format(
                "§6[Portal Calculator]§r Nether coords : §c%d§r, §a%d§r, §b%d",
                nether[0], y, nether[1]
            );
        } else if (dimension.equals("minecraft:the_nether")) {
            long[] overworld = toOverworld(x, z);
            message = String.format(
                "§6[Portal Calculator]§r Overworld coords : §c%d§r, §a%d§r, §b%d",
                overworld[0], y, overworld[1]
            );
        } else {
            message = "§cNether portal can not be used in this dimension.";
        }
        sendMessage(player, message);
        return 1;
    }

    private int executeToNether(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = getPlayer(context);
        if (player == null) return 0;
        int x = IntegerArgumentType.getInteger(context, "x");
        int y = IntegerArgumentType.getInteger(context, "y");
        int z = IntegerArgumentType.getInteger(context, "z");
        long[] nether = toNether(x, z);
        sendMessage(player, String.format(
            "§6[Portal Calculator]§r Overworld (§c%d§r, §a%d§r, §b%d§r) → Nether (§c%d§r, §a%d§r, §b%d§r)",
            x, y, z, nether[0], y, nether[1]
        ));
        return 1;
    }

    private int executeToOverworld(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = getPlayer(context);
        if (player == null) return 0;
        int x = IntegerArgumentType.getInteger(context, "x");
        int y = IntegerArgumentType.getInteger(context, "y");
        int z = IntegerArgumentType.getInteger(context, "z");
        long[] overworld = toOverworld(x, z);
        sendMessage(player, String.format(
            "§6[Portal Calculator]§r Nether (§c%d§r, §a%d§r, §b%d§r) → Overworld (§c%d§r, §a%d§r, §b%d§r)",
            x, y, z, overworld[0], y, overworld[1]
        ));
        return 1;
    }
}