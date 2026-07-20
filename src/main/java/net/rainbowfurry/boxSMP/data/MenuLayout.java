package net.rainbowfurry.boxSMP.data;

import net.rainbowfurry.boxSMP.BoxSMP;
import net.rainbowfurry.boxSMP.builder.InventoryBuilder;
import net.rainbowfurry.boxSMP.builder.ItemBuilder;
import net.rainbowfurry.boxSMP.builder.Translation;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MenuLayout {

    private final Translation translation = BoxSMP.translation;
    private final InventoryBuilder inventoryBuilder = BoxSMP.inventoryBuilder;
    private final ItemBuilder itemBuilder = BoxSMP.itemBuilder;

    //Hash List For menu if exist

    public InventoryBuilder menu(Player player, String title){
        inventoryBuilder.InventoryBuilder(player, 6, translation.Translate(title));
        inventoryBuilder.fillPlaceholder(itemBuilder.setItemMaterial(Material.GRAY_STAINED_GLASS_PANE).setItemAmount(1).setItemName(translation.Translate("[]PlaceHolder")).build());
        // Create Items
        inventoryBuilder.setItem(49, itemBuilder.setItemMaterial(Material.FLOWER_BANNER_PATTERN).setItemAmount(1).setItemName(translation.Translate("Close Menu")).build());
        return inventoryBuilder;
    }

    public void addGoBack(){

    }

    public void menuSpace1(){

    }

    public void menuSpace2(){

    }

}
