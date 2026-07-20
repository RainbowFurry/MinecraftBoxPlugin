package net.rainbowfurry.boxSMP.eventListener.inventory;

import net.rainbowfurry.boxSMP.BoxSMP;
import net.rainbowfurry.boxSMP.builder.InventoryBuilder;
import net.rainbowfurry.boxSMP.builder.ItemBuilder;
import net.rainbowfurry.boxSMP.builder.Translation;
import net.rainbowfurry.boxSMP.data.MenuLayout;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BoxMenuClickEvent implements Listener {

    private final Translation translation = BoxSMP.translation;
    private InventoryBuilder inventoryBuilder = BoxSMP.inventoryBuilder;
    private final ItemBuilder itemBuilder = BoxSMP.itemBuilder;
    private final MenuLayout menuLayout = new MenuLayout();

    @EventHandler
    public void boxMenuClick(InventoryClickEvent event) {

        if(event.getCurrentItem() != null) {
            if (event.getCurrentItem().getType().equals(Material.FLOWER_BANNER_PATTERN)) {
                if (event.getCurrentItem().getItemMeta().getItemName().equals("Close Menu")) {
                    event.setCancelled(true);
                    event.getInventory().close();
                    return;
                }
            }

            if (!event.getView().getTitle().equals(translation.Translate("<gradient:#ff0055:#5500ff>Box Menu</gradient>")))
                return;

            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();

            if (event.getCurrentItem() != null)
                switch (event.getCurrentItem().getType()) {

                    case END_CRYSTAL:
                        setBoxHome(player);
                        break;

                    case ENDER_PEARL:
                        teleportToBoxHome(player);
                        break;

                    case EMERALD:
                        friendsBoxesMenu(player);
                        break;

                    case PLAYER_HEAD:
                        addFriendsToBoxMenu(player);
                        break;

                    case WRITTEN_BOOK:
                        renameBox();
                        break;

                    case NETHERITE_UPGRADE_SMITHING_TEMPLATE:
                        upgradeBoxMenu(player);
                        break;

                    //case FLOWER_BANNER_PATTERN:
                    // Abbrechen
                    // break;

                    case CHEST:
                        // Boxen
                        break;

                }
        }

    }

    private void setBoxHome(Player player){
        Location location = player.getLocation();
        World world = player.getWorld();
    }

    private void teleportToBoxHome(Player player){
        Location location = new Location(Bukkit.getWorld(""), 1, 1,  1, 1, 1);
    }

    private void friendsBoxesMenu(Player player){
        inventoryBuilder = menuLayout.menu(player, "<gradient:#ff0055:#5500ff>Your Friends Boxes Menu</gradient>");
        inventoryBuilder.setItem(20, itemBuilder.setItemMaterial(Material.EMERALD_BLOCK).setItemAmount(1).setItemName(translation.TranslateMessage("Friends Boxname")).build());
   //hash
    player.openInventory(inventoryBuilder.createInventory());
    }

    private void addFriendsToBoxMenu(Player player){
        inventoryBuilder = menuLayout.menu(player, "<gradient:#ff0055:#5500ff>Add Friend to Box Menu</gradient>");
        inventoryBuilder.setItem(20, itemBuilder.setItemMaterial(Material.PLAYER_HEAD).setItemAmount(1).setItemName(translation.TranslateMessage("Freund Name")).build());
        inventoryBuilder.setItem(21, itemBuilder.setItemMaterial(Material.PLAYER_HEAD).setItemAmount(1).setItemName(translation.TranslateMessage("Add Friend")).build());
        //hash
        player.openInventory(inventoryBuilder.createInventory());
    }

    private void renameBox(){

    }

    private void upgradeBoxMenu(Player player){
        inventoryBuilder = menuLayout.menu(player, "<gradient:#ff0055:#5500ff>Upgrade Box Menu</gradient>");
        inventoryBuilder.setItem(11, itemBuilder.setItemMaterial(Material.END_CRYSTAL).setItemAmount(1).setItemName(translation.TranslateMessage("ttt")).build());
        //hash
        player.openInventory(inventoryBuilder.createInventory());
    }

}
