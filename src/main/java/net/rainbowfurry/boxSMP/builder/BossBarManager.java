package net.rainbowfurry.boxSMP.builder;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class BossBarManager {

    // Rework ...

    private final Map<Player, BossBar> bossBars = new HashMap<>();

    public void create(Player player, String title, BarColor color, BarStyle style) {
        remove(player);

        BossBar bossBar = Bukkit.createBossBar(title, color, style);
        bossBar.addPlayer(player);
        bossBar.setVisible(true);

        bossBars.put(player, bossBar);
    }

    public void setTitle(Player player, String title) {
        BossBar bossBar = bossBars.get(player);
        if (bossBar != null) {
            bossBar.setTitle(title);
        }
    }

    public void setProgress(Player player, double progress) {
        BossBar bossBar = bossBars.get(player);
        if (bossBar != null) {
            bossBar.setProgress(Math.max(0, Math.min(1, progress)));
        }
    }

    public void setVisible(Player player, boolean visible) {
        BossBar bossBars = this.bossBars.get(player);
        if (bossBars != null) {
            bossBars.setVisible(visible);
        }
    }

    public void remove(Player player) {
        BossBar bossBar = bossBars.remove(player);
        if (bossBar != null) {
            bossBar.removeAll();
        }
    }

}
