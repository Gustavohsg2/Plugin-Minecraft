package projeto.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public Item(Material m, int qtd, short data) {
        itemStack = new ItemStack(m, qtd, data);
        itemMeta = itemStack.getItemMeta();
    }

    public Item setName(String name){
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return this; // Quer dizer que tem mais ações a serem feitas
    }

    public ItemStack getItemStack(){
        return itemStack;
    }
}
