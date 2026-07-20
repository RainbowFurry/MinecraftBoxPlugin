package net.rainbowfurry.boxSMP.eventListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BoxBuildEvents implements Listener {

    @EventHandler
    public void onTest(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(!player.getWorld().getName().contains(player.getUniqueId().toString())){
            //Check if friend than acces else not
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTest(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(!player.getWorld().getName().contains(player.getUniqueId().toString())){
            //Check if friend than acces else not
            event.setCancelled(true);
        }
    }

}
