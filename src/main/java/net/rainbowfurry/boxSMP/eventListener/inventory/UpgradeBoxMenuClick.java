package net.rainbowfurry.boxSMP.eventListener.inventory;

import net.rainbowfurry.boxSMP.BoxSMP;
import net.rainbowfurry.boxSMP.builder.InventoryBuilder;
import net.rainbowfurry.boxSMP.builder.ItemBuilder;
import net.rainbowfurry.boxSMP.builder.Translation;
import net.rainbowfurry.boxSMP.data.MenuLayout;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class UpgradeBoxMenuClick implements Listener {

    private final Translation translation = BoxSMP.translation;
    private InventoryBuilder inventoryBuilder = BoxSMP.inventoryBuilder;
    private final ItemBuilder itemBuilder = BoxSMP.itemBuilder;
    private final MenuLayout menuLayout = new MenuLayout();

    @EventHandler
    public void boxMenuClick(InventoryClickEvent event) {

        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().getType().equals(Material.FLOWER_BANNER_PATTERN)) {
                if (event.getCurrentItem().getItemMeta().getItemName().equals("Close Menu")) {
                    event.setCancelled(true);
                    event.getInventory().close();
                    return;
                }
            }

            if (!event.getView().getTitle().equals(translation.Translate("<gradient:#ff0055:#5500ff>Upgrade Box Menu</gradient>")))
                return;

            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();

            if (event.getCurrentItem() != null)
                switch (event.getCurrentItem().getType()) {

                }

        }

    }

}
