package net.rainbowfurry.boxSMP.eventListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;

public class BoxInteractionEvents implements Listener {

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            event.setCancelled(false);
            return;
        }

        Player player = (Player) event.getEntity();
        if (!player.getWorld().getName().contains(player.getUniqueId().toString())) {
            //Check if friend than acces else not
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onMobDamage(EntityDamageByEntityEvent event) {

        if (!(event.getEntity() instanceof Player))
            if (event.getDamager() instanceof Player)
                if (!event.getDamager().getWorld().getName().contains(event.getDamager().getUniqueId().toString()))
                    //Check if friend than acces else not
                    event.setCancelled(true);
                else
                    event.setCancelled(true);

        event.setCancelled(false);
    }

    @EventHandler
    public void onPickUp(PlayerAttemptPickupItemEvent event){

        Player player = event.getPlayer();
        if (!player.getWorld().getName().contains(player.getUniqueId().toString())) {
            //Check if friend than acces else not
            event.setCancelled(true);
        }
        event.setCancelled(false);
    }

}
