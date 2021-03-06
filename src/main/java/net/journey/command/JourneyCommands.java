package net.journey.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class JourneyCommands extends CommandBase {

    @Override
    public String getName() {
        return "journey";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/journey";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender var1, String[] var2) throws CommandException {
        EntityPlayerMP p = null;
        try {
            p = getCommandSenderAsPlayer(var1);
        } catch (PlayerNotFoundException e) {
            e.printStackTrace();
        }
        if (var2[0].equalsIgnoreCase("Heal")) {
            if (p.getHealth() < p.getMaxHealth())
                p.heal(20);
            if (p.getFoodStats().needFood())
                p.getFoodStats().addStats(20, 1);
        }

        EntityPlayerMP playerMP = (EntityPlayerMP) var1;
		/*if(!playerMP.world.isRemote) {
			if(var2[0].equalsIgnoreCase("Overworld")) {
				if(playerMP.dimension != 0) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, 0, new Teleporter(playerMP.server.getWorld(0)));
				}
			}

			if(var2[0].equalsIgnoreCase("Nether")) {
				if(playerMP.dimension != -1) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, -1, new Teleporter(playerMP.server.getWorld(-1)));
				}
			}

			if(var2[0].equalsIgnoreCase("End")) {
				if(playerMP.dimension != 1) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, 1, new Teleporter(playerMP.server.getWorld(1)));
				}
			}

			if(var2[0].equalsIgnoreCase("Euca")) {
				if(playerMP.dimension != Config.euca) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, Config.euca, new ModTeleporter(playerMP.server.getWorld(Config.euca), Config.euca, JourneyBlocks.eucaPortal, JourneyBlocks.eucaPortalFrame, BlockEucaPortal.AXIS));
				}
			}

			if(var2[0].equalsIgnoreCase("BoilingPoint")) {
				if(playerMP.dimension != Config.boil) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, Config.boil, new ModTeleporter(playerMP.server.getWorld(Config.boil), Config.boil, JourneyBlocks.boilPortal, JourneyBlocks.boilPortalFrame, BlockBoilPortal.AXIS));
				}
			}

			if(var2[0].equalsIgnoreCase("Depths")) {
				if(playerMP.dimension != Config.depths) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, Config.depths, new TeleporterDepths(playerMP.server.getWorld(Config.depths)));
				}
			}
			
			if(var2[0].equalsIgnoreCase("FrozenLands")) {
				if(playerMP.dimension != Config.frozen) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, Config.frozen, new ModTeleporter(playerMP.server.getWorld(Config.frozen), Config.frozen, JourneyBlocks.frozenPortal, JourneyBlocks.frozenPortalFrame, BlockFrozenPortal.AXIS));
				}
			}
			
			if(var2[0].equalsIgnoreCase("Corba")) {
				if(playerMP.dimension != Config.corba) {
					playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, Config.corba, new TeleporterCorba(playerMP.server.getWorld(Config.corba)));
				}
			}
		}*/
    }
}