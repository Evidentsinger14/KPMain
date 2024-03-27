package org.newplugin.kpmain.GUI;

import java.util.Collections;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PhysicalGUI {
    public static void OpenGUI(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)player, 9, ChatColor.BLACK + "KP Physical Tokens");
        ItemStack Token1 = createTokenItem(Material.SUNFLOWER, "1 Physical Token", 100, player);
        ItemStack Token2 = createTokenItem(Material.SUNFLOWER, "5 Physical Tokens", 500, player);
        ItemStack Token3 = createTokenItem(Material.SUNFLOWER, "10 Physical Tokens", 1000, player);
        ItemStack goBack = RanksGUI.createGoBack();
        inv.setItem(0, Token1);
        inv.setItem(1, Token2);
        inv.setItem(2, Token3);
        inv.setItem(8, goBack);
        player.openInventory(inv);
    }

    private static ItemStack createTokenItem(Material material, String displayName, int tokens, Player player) {
        ItemStack claimItem = new ItemStack(material);
        ItemMeta meta = claimItem.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + displayName);
        meta.setLore(Collections.singletonList(ChatColor.GRAY + "Tokens: " + ChatColor.YELLOW + tokens));
        claimItem.setItemMeta(meta);
        return claimItem;
    }
}
