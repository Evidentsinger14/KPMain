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

public class CommandGUI {
    public static void OpenGUI(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.BLACK + "KP Command Shop");
        inv.setItem(0, createCommandItem(Material.FEATHER, "/fly", 1000, player, "essentials.fly"));
        inv.setItem(1, createCommandItem(Material.REDSTONE, "/nick (Colors)", 1000, player, "essentials.nick.color"));
        inv.setItem(2, createCommandItem(Material.INK_SAC, "/nick (No Colors)", 1000, player, "essentials.nick"));
        inv.setItem(3, createCommandItem(Material.ANVIL, "/fix", 1000, player, "essentials.repair"));
        inv.setItem(4, createCommandItem(Material.CHEST, "/fix all", 1000, player, "essentials.repair.all"));
        inv.setItem(5, createCommandItem(Material.DIAMOND_HELMET, "/hat", 1000, player, "essentials.hat"));
        inv.setItem(6, createCommandItem(Material.CLOCK, "/ptime", 1000, player, "essentials.ptime"));
        inv.setItem(7, createCommandItem(Material.WHITE_WOOL, "/pweather", 1000, player, "essentials.pweather"));
        inv.setItem(8, createCommandItem(Material.GOLDEN_APPLE, "/heal", 1000, player, "essentials.heal"));
        inv.setItem(9, createCommandItem(Material.BREAD, "/feed", 1000, player, "essentials.feed"));
        inv.setItem(10, createCommandItem(Material.CRAFTING_TABLE, "/craft (Comes with /anvil)", 1000, player, "essentials.workbench"));
        inv.setItem(11, createCommandItem(Material.ENDER_CHEST, "/enderchest", 1000, player, "essentials.enderchest"));
        inv.setItem(12, createCommandItem(Material.PLAYER_HEAD, "/skull", 500, player, "essentials.skull"));
        inv.setItem(26, RanksGUI.createGoBack());
        player.openInventory(inv);
    }

    private static ItemStack createCommandItem(Material material, String displayName, int tokens, Player player, String command) {
        ItemStack commandItem = new ItemStack(material);
        ItemMeta meta = commandItem.getItemMeta();
        meta.setDisplayName(ChatColor.BOLD + displayName);
        if (player.hasPermission(command)) {
            meta.setLore(Collections.singletonList(ChatColor.GRAY + "Already own this command."));
        } else {
            meta.setLore(Collections.singletonList(ChatColor.GRAY + "Tokens: " + ChatColor.YELLOW + tokens));
        }
        commandItem.setItemMeta(meta);
        return commandItem;
    }
}
