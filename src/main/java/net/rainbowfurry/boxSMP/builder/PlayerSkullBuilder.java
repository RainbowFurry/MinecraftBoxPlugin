package net.rainbowfurry.boxSMP.builder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerSkullBuilder {

    public ItemStack getPlayerHead(String playerName) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();

        meta.setOwningPlayer(Bukkit.getOfflinePlayer(playerName));

        head.setItemMeta(meta);
        return head;
    }

}
