package net.rainbowfurry.boxSMP;

import net.rainbowfurry.boxSMP.builder.CustomMenu;
import net.rainbowfurry.boxSMP.builder.InventoryBuilder;
import net.rainbowfurry.boxSMP.builder.ItemBuilder;
import net.rainbowfurry.boxSMP.builder.Translation;
import net.rainbowfurry.boxSMP.commands.BoxCommand;
import net.rainbowfurry.boxSMP.commands.RandomTeleport;
import net.rainbowfurry.boxSMP.commands.TestCommand;
import net.rainbowfurry.boxSMP.eventListener.BoxBuildEvents;
import net.rainbowfurry.boxSMP.eventListener.BoxInteractionEvents;
import net.rainbowfurry.boxSMP.eventListener.BoxManagementEvents;
import net.rainbowfurry.boxSMP.eventListener.inventory.*;
import net.rainbowfurry.boxSMP.manager.ConfigManager;
import net.rainbowfurry.boxSMP.manager.PluginConfigManager;
import net.rainbowfurry.boxSMP.manager.LogManager;
import net.rainbowfurry.boxSMP.manager.WorldManager;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class BoxSMP extends JavaPlugin {

    public static Plugin plugin;
    public static LogManager logManager;
    public static PluginConfigManager pluginConfigManager;
    public static ConfigManager configManager;
    public static Translation translation;
    public static InventoryBuilder inventoryBuilder;
    public static ItemBuilder itemBuilder;
    public static WorldManager worldManager;
    public static CustomMenu customMenu;

    // DB
    // Money System

    @Override
    public void onEnable() {

        inti();

        // Money System
        // DB

        // Register Commands
        registerCommands();

        // Register Listener
        registerEvents();

    }

    @Override
    public void onDisable() {
        logManager.info( "<red>The Plugin</red> <yellow>BoxSMP</yellow> <red>is getting</red> <dark_red><b>stopped</b>!</dark_red>");
    }

    private void inti(){
        plugin = this;
        logManager = new LogManager();
        pluginConfigManager = new PluginConfigManager();
        configManager = new ConfigManager();
        translation = new Translation();
        inventoryBuilder  = new InventoryBuilder();
        itemBuilder  = new ItemBuilder(Material.AIR);
        worldManager = new WorldManager();
        customMenu = new CustomMenu();
        logManager.info("<green>The Plugin</green> <yellow>BoxSMP</yellow> <green>is getting</green> <lime_green><b>started</b>!</lime_green>");
        logManager.info("<aqua>Developer</aqua>: <gradient:#FF0000:#FF7F00:#FFFF00:#00FF00:#0000FF:#8B00FF><b>RainbowFurry</b></gradient>");
    }

    private void registerCommands(){
        logManager.info( "Start register all Commands...");
        getCommand("test").setExecutor(new TestCommand());
        getCommand("box").setExecutor(new BoxCommand());
        getCommand("rtp").setExecutor(new RandomTeleport());
        logManager.info( "All Commands have been registered!");
    }

    private void registerEvents(){
        logManager.info( "Start register all Events...");
        getServer().getPluginManager().registerEvents(new BoxBuildEvents(), this);
        getServer().getPluginManager().registerEvents(new BoxInteractionEvents(), this);
        getServer().getPluginManager().registerEvents(new BoxManagementEvents(), this);

        getServer().getPluginManager().registerEvents(new BoxMenuClickEvent(), this);
        getServer().getPluginManager().registerEvents(new RTPMenuClick(), this);

        getServer().getPluginManager().registerEvents(new AddFriendsMenuClick(), this);
        getServer().getPluginManager().registerEvents(new FriendsBoxMenuClick(), this);
        getServer().getPluginManager().registerEvents(new UpgradeBoxMenuClick(), this);
        logManager.info("All Events have been registered!");
    }

}
