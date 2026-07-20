package net.rainbowfurry.boxSMP.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.structure.Structure;
import org.bukkit.util.StructureSearchResult;

import java.util.Random;

public class RTPManager {

    private Random random = new Random();

    public void findRandomLocation() {

        int chance = random.nextInt(100);

        if (chance < 30) {
            World world = Bukkit.getWorld("world");
            findStructureLocation(world, findNormalLocation());
        } else {
            findNormalLocation();
        }
    }

    private Location findNormalLocation(){

        int x = random.nextInt(20000) - 10000;
        int z = random.nextInt(20000) - 10000;

        World world = Bukkit.getWorld("world");

        int y = world.getHighestBlockYAt(x, z);

        Location location = new Location(world, x + 0.5, y + 1, z + 0.5);

        if(checkForSafeLocation(location))
        return location;

        return null;
    }

    private Location findStructureLocation(World world, Location location) {

        StructureSearchResult result =
                world.locateNearestStructure(
                        location,
                        Structure.VILLAGE_DESERT,
                        10000,
                        false
                );
        if(checkForSafeLocation(result.getLocation()))
            return result.getLocation();
        return null;
    }

    public boolean checkForSafeLocation(Location location) {
        Block feet = location.getBlock();
        Block ground = feet.getRelative(BlockFace.DOWN);

        if (feet.isPassable()
                && feet.getRelative(BlockFace.UP).isPassable()
                && ground.getType().isSolid()) {

            //check for water, lava, fire, ...

            //player.teleport(location);
            return true;
        }else{
            findRandomLocation();
            return false;
        }
    }

}
