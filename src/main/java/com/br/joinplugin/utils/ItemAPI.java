package com.br.joinplugin.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemAPI {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemAPI(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemAPI setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemAPI setName(String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemAPI lore(List<String> lore) {
        itemMeta.setLore(lore);
        return this;
    }

    public ItemAPI addLore(String loreLine) {
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        lore.add(loreLine);
        itemMeta.setLore(lore);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
