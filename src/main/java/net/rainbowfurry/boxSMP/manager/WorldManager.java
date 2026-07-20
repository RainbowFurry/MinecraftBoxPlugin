package net.rainbowfurry.boxSMP.manager;

import org.bukkit.*;

import java.io.File;

public class WorldManager {

    private WorldCreator worldCreator;

    // Message wird erstellt., welt erstellen, border erstellen, welt laden, tp,
    // Wenn welten existieren zu erst laden, wenn welt da dann tp  sonst erstelle random welche wenn beides nicht da.
    // game rules : diff 3, mobgriefing aus, neter?, ...
    // Danach uid.dat, session lock löschen
    // on Join / leave / change wold -> Welt laden, entladen, etc.

    public boolean worldExist(String name){
        World world = Bukkit.getWorld(name);
        if(world != null)
            return true;
        return false;
    }

    public void createWorldBySeed(String name, long seed){

        World world = Bukkit.getWorld(name);
        if(world != null)
            return;

        worldCreator = new WorldCreator(name);
        worldCreator.seed(seed); // 2702385598947346495L - Test Seed
        worldCreator.type(WorldType.NORMAL);
        // difficulty
        // gamerules
        worldCreator.createWorld();
    }

    public void createEndBySeed(){
        //...
    }

    public void copyEnd(){
        //...
    }

    public void createNetherBySeed(){
        //...
    }

    public void copyNether(){
        //...
    }

    public void copyWorld(String from, String to){
        //... ttt
    }

    public void deleteWorld(String name){
        //... ttt
    }

    public boolean isWorldLoaded(String name){
        if(Bukkit.getWorld(name) != null)
        //if(Bukkit.getWorlds().contains(name))
            return true;
        return false;
    }

    public void loadWorld(String name){
        //... ttt
    }

    public void unloadWorld(String name) {
        //... ttt
    }

    public void createBorder(String name, int size){
        World world = Bukkit.getWorld(name);
        WorldBorder border = world.getWorldBorder();
        border.setCenter(world.getSpawnLocation().getX(), world.getSpawnLocation().getY());
        border.setSize(size);
    }

    public void expandBorder(String name, double size){
        World world = Bukkit.getWorld(name);
        WorldBorder border = world.getWorldBorder();
        border.setCenter(world.getSpawnLocation().getX(), world.getSpawnLocation().getY());
        border.setSize(size, (long) 3.0F);
        //border.setSize(100, 3);
    }

    // Not DONE!
    public void loadAllWorlds(){
        //Nur geladene Welten
        for (World world : Bukkit.getWorlds()) {
            Bukkit.getLogger().info(world.getName()); //
        }
    }

    // Not DONE!
    public void unloadAllWorlds(){
        // Alle Welten im default Ordner
        File worldContainer = Bukkit.getWorldContainer();

        File[] files = worldContainer.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    Bukkit.getLogger().info(file.getName()); //
                }
            }
        }
    }

}
