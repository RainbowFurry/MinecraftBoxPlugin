package net.rainbowfurry.boxSMP.eventListener;

import net.rainbowfurry.boxSMP.BoxSMP;
import net.rainbowfurry.boxSMP.data.BoxStats;
import net.rainbowfurry.boxSMP.manager.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class BoxManagementEvents implements Listener {

    private final ConfigManager configManager = BoxSMP.configManager;
    private HashMap<Player, BoxStats> cach = new HashMap<>(); //wo anderst hin packen...

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        if(event.getPlayer().getFirstPlayed() == 0.0)
            player.sendMessage("Erster Join HEY!");
        else
            player.sendMessage("Willkommen zurück!");

        BoxStats boxStats = new BoxStats();
        // load config
        //boxStats.Owner = configManager.getConfig();

        cach.put(player, boxStats);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){

        Player player = event.getPlayer();
        player.sendMessage("Schade dass du gehst...");

        cach.remove(player);

    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event){

        Player player = event.getPlayer();

        String text = "Du hast die welt gewechselt von %von% zu %zu%";
        player.sendMessage(text.replace("%von%", event.getFrom().getName()).replace("%zu%", player.getWorld().getName()));

    }

}
