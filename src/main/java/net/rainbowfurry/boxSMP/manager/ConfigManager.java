package net.rainbowfurry.boxSMP.manager;

import net.rainbowfurry.boxSMP.BoxSMP;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfigManager {

    private final Plugin plugin = BoxSMP.plugin;

    public void test(Player player) {

        File folder = new File(plugin.getDataFolder(), "players");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder, player.getUniqueId() + ".yml");

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formatted = LocalDateTime.now().format(formatter);

        config.set("Box.Owner", player.getName());

        config.set("Box.Level.OverWorld", 1);
        config.set("Box.Level.Nether", 1);
        config.set("Box.Level.End", 1);

        config.set("Box.CreatedAt", formatted);
        config.set("Box.LastAccessedAt", formatted);

        config.set("Box.Friends.1", "Spieler 1");
        config.set("Box.Friends.2", "Spieler 2");
        config.set("Box.Friends.3", "Spieler 3");
        config.set("Box.Friends.4", "Spieler 4");
        config.set("Box.Friends.5", "Spieler 5");

        config.set("Box.Home.X", 1);
        config.set("Box.Home.Y", 1);
        config.set("Box.Home.Z", 1);
        config.set("Box.Home.Yaw", 1.0F);
        config.set("Box.Home.Pitch", 1.0F);

        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void createConfig(){

    }

    public void updateConfig(){

    }

    public void getConfig(){

    }

    public void loadConfig(){

    }

    public void unloadConfig(){

    }

}
