package net.rainbowfurry.boxSMP.commands;

import net.rainbowfurry.boxSMP.BoxSMP;
import net.rainbowfurry.boxSMP.builder.InventoryBuilder;
import net.rainbowfurry.boxSMP.builder.ItemBuilder;
import net.rainbowfurry.boxSMP.builder.Translation;
import net.rainbowfurry.boxSMP.data.MenuLayout;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BoxCommand implements CommandExecutor {

    private InventoryBuilder inventoryBuilder = BoxSMP.inventoryBuilder;
    private final ItemBuilder itemBuilder = BoxSMP.itemBuilder;
    private final Translation translation = BoxSMP.translation;

    private Inventory BoxMenu_Inventory;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if(!(commandSender instanceof Player))
            return false;

        // if not in world tp, else menu
        // world exist, world loaded, but only if home or world exist else create

        Player player = (Player) commandSender;

        /**
        if(args.length > 0) {
            switch (args[0]) {

                case "friends":
                    //
                    break;

         case "create":
         //
         break;

         case "delete":
         //
         break;

                case "help":
                    //
                    break;

                case "visit":
                    //
                    break;

                default:
                    //
                    break;

            }
        }**/

        if(BoxMenu_Inventory == null)
            createBoxMenuInventory(player);

        player.openInventory(BoxMenu_Inventory);

        return true;
    }

    private void createBoxMenuInventory(Player player){
        MenuLayout menuLayout = new MenuLayout();
        inventoryBuilder = menuLayout.menu(player, "<gradient:#ff0055:#5500ff>Box Menu</gradient>");
        //inventoryBuilder.InventoryBuilder(player, 6, translation.Translate("<gradient:#ff0055:#5500ff>Box Menu</gradient>"));
        //inventoryBuilder.fillPlaceholder(itemBuilder.setItemMaterial(Material.GRAY_STAINED_GLASS_PANE).setItemAmount(1).setItemName(translation.TranslateMessage("[]PlaceHolder")).build());
        // Create Items
        inventoryBuilder.setItem(11, itemBuilder.setItemMaterial(Material.END_CRYSTAL).setItemAmount(1).setItemName(translation.TranslateMessage("&a&lSet the Box Home")).setItemLore(itemLoreBuilder("&4&lBOX HOME BUTTON", "&6&lClick here to redefine the box home")).build());
        inventoryBuilder.setItem(13, itemBuilder.setItemMaterial(Material.ENDER_PEARL).setItemAmount(1).setItemName(translation.TranslateMessage("&a&lTeleport to the Box")).build());
        inventoryBuilder.setItem(15, itemBuilder.setItemMaterial(Material.EMERALD).setItemAmount(1).setItemName(translation.TranslateMessage("&a&lYour Friends Boxes")).build());
        //
        inventoryBuilder.setItem(30, itemBuilder.setItemMaterial(Material.PLAYER_HEAD).setItemAmount(1).setItemName(translation.TranslateMessage("&a&lAdd Friends to your Boxe")).build());
        inventoryBuilder.setItem(30, itemBuilder.setItemMaterial(Material.PLAYER_HEAD).setItemAmount(1).setItemName(translation.Translate("<gradient:#FF416C:#FF4B2B:#FF8C00>Add Friends to your Boxe</gradient>")).build());//REMOVE
        inventoryBuilder.setItem(31, itemBuilder.setItemMaterial(Material.WRITABLE_BOOK).setItemAmount(1).setItemName(translation.TranslateMessage("&a&lRename your Box Name")).build());
        inventoryBuilder.setItem(31, itemBuilder.setItemMaterial(Material.WRITABLE_BOOK).setItemAmount(1).setItemName(translation.Translate("<gradient:#4A00E0:#8E2DE2:#F000FF>Rename your Box Name</gradient>")).build());//REMOVE
        inventoryBuilder.setItem(32, itemBuilder.setItemMaterial(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE).setItemAmount(1).setItemName(translation.TranslateMessage("&a&lUpgrade your Box Size")).build());
        inventoryBuilder.setItem(32, itemBuilder.setItemMaterial(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE).setItemAmount(1).setItemName(translation.Translate("<gradient:#FF007F:#9B51E0:#00F2FE>Upgrade your Box Size</gradient>")).build());//REMOVE
        inventoryBuilder.setItem(32, itemBuilder.setItemMaterial(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE).setItemAmount(1).setItemName(translation.Translate("<gradient:#004BFF:#8A2BE2:#FF007F><b>Blau Pink</b></gradient>")).build());//REMOVE
        //
        //inventoryBuilder.setItem(49, itemBuilder.setItemMaterial(Material.FLOWER_BANNER_PATTERN).setItemAmount(1).setItemName(translation.TranslateMessage("Close Menu")).build());
        //inventoryBuilder.setItem(49, itemBuilder.setItemMaterial(Material.FLOWER_BANNER_PATTERN).setItemAmount(1).setItemName(translation.Translate("<gradient:#5BCEFA:#F5A9B8:#FFFFFF:#F5A9B8:#5BCEFA><b>Transgender</b></gradient>")).build());//REMOVE
        inventoryBuilder.setItem(50, itemBuilder.setItemMaterial(Material.CHEST).setItemAmount(1).setItemName(translation.TranslateMessage("&a&lYour Boxes (Comming soon...)")).build());
        inventoryBuilder.setItem(50, itemBuilder.setItemMaterial(Material.CHEST).setItemAmount(1).setItemName(translation.Translate("<gradient:#FF0000:#FF7F00:#FFFF00:#00FF00:#0000FF:#8B00FF><b>Regenbogen🌍‍⚧</b></gradient>")).build());//REMOVE
        //
        BoxMenu_Inventory = inventoryBuilder.createInventory();
    }

    private List<String> itemLoreBuilder(String description, String action){

        List<String> lore = List.of(
                translation.Translate("<red>"+ description + "</red>"),
                translation.Translate(" "),
                translation.Translate("<green>" + action + "</green>")
        );
        return lore;
    }

}
