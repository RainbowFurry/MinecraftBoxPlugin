package net.rainbowfurry.boxSMP.builder;

import org.bukkit.entity.Player;

public class XpBarManager {

    public void set(Player player, float progress, int level) {
        player.setExp(Math.max(0F, Math.min(1F, progress)));
        player.setLevel(level);
    }

    public void setProgress(Player player, float progress) {
        player.setExp(Math.max(0F, Math.min(1F, progress)));
    }

    public void setLevel(Player player, int level) {
        player.setLevel(level);
    }

    public void reset(Player player) {
        player.setExp(0F);
        player.setLevel(0);
    }

}
