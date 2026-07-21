package net.rainbowfurry.boxSMP.builder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;

public class ScoreboadBuilder {

    // REWORK ...

    private final Map<Player, Scoreboard> scoreboards = new HashMap<>();

    public void create(Player player, String title) {
        org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("sidebar", Criteria.DUMMY, ChatColor.translateAlternateColorCodes('&', title));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        scoreboards.put(player, scoreboard);
        player.setScoreboard(scoreboard);
    }

    public void setLine(Player player, int score, String text) {
        Scoreboard scoreboard = scoreboards.get(player);
        if (scoreboard == null) return;

        Objective objective = scoreboard.getObjective(DisplaySlot.SIDEBAR);
        if (objective == null) return;

        objective.getScore(ChatColor.translateAlternateColorCodes('&', text)).setScore(score);
    }

    public void removeLine(Player player, String text) {
        Scoreboard scoreboard = scoreboards.get(player);
        if (scoreboard == null) return;

        scoreboard.resetScores(ChatColor.translateAlternateColorCodes('&', text));
    }

    public void setTitle(Player player, String title) {
        Scoreboard scoreboard = scoreboards.get(player);
        if (scoreboard == null) return;

        Objective objective = scoreboard.getObjective(DisplaySlot.SIDEBAR);
        if (objective != null) {
            objective.displayName(ChatColor.translateAlternateColorCodes('&', title));
        }
    }

    public void remove(Player player) {
        scoreboards.remove(player);
        player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
    }

    public void clear(Player player) {
        Scoreboard scoreboard = scoreboards.get(player);
        if (scoreboard == null) return;

        for (String entry : scoreboard.getEntries()) {
            scoreboard.resetScores(entry);
        }
    }

    public void updateLine(Player player, int score, String oldText, String newText) {
        Scoreboard scoreboard = scoreboards.get(player);
        if (scoreboard == null) return;

        Objective objective = scoreboard.getObjective(DisplaySlot.SIDEBAR);
        if (objective == null) return;

        scoreboard.resetScores(ChatColor.translateAlternateColorCodes('&', oldText));
        objective.getScore(ChatColor.translateAlternateColorCodes('&', newText)).setScore(score);
    }

}
