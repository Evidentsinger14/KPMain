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

public class ClaimblocksGUI {
    public static void OpenGUI(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)player, 9, ChatColor.BLACK + "KP Claimblock Shop");
        ItemStack Claim1 = createClaimItem(Material.GOLDEN_SHOVEL, "2000 Claimblocks", 350, player);
        ItemStack Claim2 = createClaimItem(Material.GOLDEN_SHOVEL, "5000 Claimblocks", 700, player);
        ItemStack Claim3 = createClaimItem(Material.GOLDEN_SHOVEL, "10000 Claimblocks", 1500, player);
        ItemStack Claim4 = createClaimItem(Material.GOLDEN_SHOVEL, "20000 Claimblocks", 2500, player);
        ItemStack Claim5 = createClaimItem(Material.GOLDEN_SHOVEL, "40000 Claimblocks", 5000, player);
        ItemStack goBack = RanksGUI.createGoBack();
        inv.setItem(0, Claim1);
        inv.setItem(1, Claim2);
        inv.setItem(2, Claim3);
        inv.setItem(3, Claim4);
        inv.setItem(4, Claim5);
        inv.setItem(8, goBack);
        player.openInventory(inv);
    }

    private static ItemStack createClaimItem(Material material, String displayName, int tokens, Player player) {
        ItemStack claimItem = new ItemStack(material);
        ItemMeta meta = claimItem.getItemMeta();
        meta.setDisplayName(ChatColor.BOLD + displayName);
        meta.setLore(Collections.singletonList(ChatColor.GRAY + "Tokens: " + ChatColor.YELLOW + tokens));
        claimItem.setItemMeta(meta);
        return claimItem;
    }
}
