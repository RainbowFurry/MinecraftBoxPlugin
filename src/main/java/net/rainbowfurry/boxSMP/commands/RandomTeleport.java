package net.rainbowfurry.boxSMP.commands;

import net.rainbowfurry.boxSMP.BoxSMP;
import net.rainbowfurry.boxSMP.builder.InventoryBuilder;
import net.rainbowfurry.boxSMP.builder.ItemBuilder;
import net.rainbowfurry.boxSMP.builder.Translation;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class RandomTeleport implements CommandExecutor {

    private final InventoryBuilder inventoryBuilder = BoxSMP.inventoryBuilder;
    private final ItemBuilder itemBuilder = BoxSMP.itemBuilder;
    private final Translation translation = BoxSMP.translation;

    private Inventory RTP_Menu_Inventory;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if(!(commandSender instanceof Player))
            return false;

        Player player = (Player) commandSender;

        if(RTP_Menu_Inventory == null)
            createRTPMenu(player);

        player.openInventory(RTP_Menu_Inventory);

        return true;
    }

    private void createRTPMenu(Player player){
        inventoryBuilder.InventoryBuilder(player, 3, translation.Translate("<gradient:#ff0055:#5500ff>RTP - Random Teleport</gradient>"));
        inventoryBuilder.fillPlaceholder(itemBuilder.setItemMaterial(Material.GRAY_STAINED_GLASS_PANE).setItemAmount(1).setItemName(translation.TranslateMessage("[]PlaceHolder")).build());
        // Create Items
        inventoryBuilder.setItem(11, itemBuilder.setItemMaterial(Material.GRASS_BLOCK).setItemAmount(1).setItemName(translation.Translate("🌍 <gradient:#55FF55:#00AA00><b>Over-World</b></gradient>")).build());
        //inventoryBuilder.setItem(11, itemBuilder.setItemMaterial(Material.GRASS_BLOCK).setItemAmount(1).setItemName(translation.Translate("🌍 <gradient:#7ED957:#2E8B57><b>World</b></gradient>")).build());
        inventoryBuilder.setItem(13, itemBuilder.setItemMaterial(Material.NETHERRACK).setItemAmount(1).setItemName(translation.Translate("🔥 <gradient:#FF5555:#AA0000><b>Nether</b></gradient>")).build());
        //inventoryBuilder.setItem(13, itemBuilder.setItemMaterial(Material.NETHERRACK).setItemAmount(1).setItemName(translation.Translate("🔥 <gradient:#FF6B35:#8B0000><b>Nether</b></gradient>")).build());
        inventoryBuilder.setItem(15, itemBuilder.setItemMaterial(Material.END_STONE).setItemAmount(1).setItemName(translation.Translate("🌑 <gradient:#FF55FF:#AA00AA><b>End<b></gradient>")).build());
        //inventoryBuilder.setItem(15, itemBuilder.setItemMaterial(Material.END_STONE).setItemAmount(1).setItemName(translation.Translate("🌑 <gradient:#C084FC:#4B0082><b>End</b></gradient>")).build());

        RTP_Menu_Inventory = inventoryBuilder.createInventory();
    }

}
