package net.rainbowfurry.boxSMP.builder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private Inventory inventory;
    //private final ItemBuilder itemBuilder = BoxPlugin.itemBuilder;
    private final ItemBuilder itemBuilder = new ItemBuilder(Material.AIR);

    public void InventoryBuilder(Player player, int rows, String title){
        //inventory = Bukkit.createInventory(player, InventoryType.CHEST, title);
        inventory = Bukkit.createInventory(player, rows * 9, title);
    }

    public void fillPlaceholder(ItemStack itemStack){
        for(int i = 0; i < inventory.getSize(); i++){
            inventory.setItem(i, itemStack);
        }
    }

    public void fillPlaceholder(){
        ItemStack itemStack = itemBuilder.setItemMaterial(Material.GRAY_STAINED_GLASS).setItemAmount(1).setItemName("[]PlaceHolder").build();
        for(int i = 0; i < inventory.getSize(); i++){
            inventory.setItem(i, itemStack);
        }
    }

    public void setItem(int slot, ItemStack item){
        inventory.setItem(slot, item);
    }

    public Inventory createInventory(){
        return inventory;
    }

}
