package net.rainbowfurry.boxSMP.builder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    ItemStack itemStack;
    ItemMeta itemMeta;

    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder setItemMaterial(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
        return this;
    }

    public ItemBuilder setItemName(String name){
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setItemAmount(int amount){
            itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setItemLore(List<String> lore){
        itemMeta.setLore(lore);
        return this;
    }

    public ItemStack build(){
        if(itemMeta != null)
            itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
