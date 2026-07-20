package net.rainbowfurry.boxSMP.manager;

import net.rainbowfurry.boxSMP.BoxSMP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class PluginConfigManager {

    private final Plugin plugin = BoxSMP.plugin;
    private final FileConfiguration config;

    public PluginConfigManager() {

        // Erstellt config.yml, falls sie nicht existiert
        plugin.saveDefaultConfig();

        config = plugin.getConfig();

        // Testwerte setzen, falls sie fehlen
        //createDefaults();

        config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    private void createDefaults(){
        config.addDefault("box.t", 2);
        config.addDefault("box.a", 256);
        config.addDefault("box.b", true);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void reload() {
        plugin.reloadConfig();
    }

    public void save() {
        plugin.saveConfig();
    }

}
