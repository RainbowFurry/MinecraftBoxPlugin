package net.rainbowfurry.boxSMP.commands;

import net.rainbowfurry.boxSMP.BoxSMP;
import net.rainbowfurry.boxSMP.builder.CustomMenu;
import net.rainbowfurry.boxSMP.manager.ConfigManager;
import net.rainbowfurry.boxSMP.manager.RTPManager;
import net.rainbowfurry.boxSMP.manager.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {

    private final CustomMenu customMenu = BoxSMP.customMenu;
    private final ConfigManager configManager = BoxSMP.configManager;
    private final RTPManager rtpManager = new RTPManager();
    private final WorldManager worldManager = new WorldManager();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;
        //customMenu.createCustomMenu(player);
        //customMenu.createCustomMenuWithLinks(player);

        //configManager.test(player); // geht
        //player.teleport(rtpManager.findRandomLocation()); // geht

        /*
        if(!worldManager.worldExist("Box_OverWorld_" + player.getUniqueId())) {
            if (!worldManager.isWorldLoaded("Box_OverWorld_" + player.getUniqueId())) {
                worldManager.createWorldBySeed("Box_OverWorld_" + player.getUniqueId(), 2702385598947346495L);
                worldManager.createBorder("Box_OverWorld_" + player.getUniqueId(), 16);
            }
        }

        World world = Bukkit.getWorld("Box_OverWorld_" + player.getUniqueId());
        Location location = new Location(world, world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ(), world.getSpawnLocation().getYaw(), world.getSpawnLocation().getPitch());
        player.teleport(location);
        * */

        //worldManager.expandBorder("Box_OverWorld_" + player.getUniqueId(), Bukkit.getWorld("Box_OverWorld_" + player.getUniqueId()).getWorldBorder().getSize() * 2);

        return false;
    }
}
