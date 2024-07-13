package org.newplugin.kpmain.GUI;

import java.util.Collections;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RanksGUI {
    private static Logger logger;

    public RanksGUI(Logger logger) {
        RanksGUI.logger = logger;
    }

    public static void OpenGUI(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)player, 9, ChatColor.BLACK + "KP Ranks Menu");
        if (!player.hasPermission("kpmain.page")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "null"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "null"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPaladin Rank", 400, player, "null"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "null"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "null"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "&1&lCommander Rank", 1000, player, "null"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "null"));
        } else if (!player.hasPermission("kpmain.squire")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "kpmain.squire"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "null"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPeridot Rank", 400, player, "null"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "null"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "null"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "&1&lCommander Rank", 1000, player, "null"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "null"));
        } else if (!player.hasPermission("kpmain.knight")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "kpmain.squire"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "kpmain.knight"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPaladin Rank", 400, player, "null"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "null"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "null"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "Commander Rank", 1000, player, "null"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "null"));
        } else if (!player.hasPermission("kpmain.paladin")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "kpmain.squire"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "kpmain.knight"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPaladin Rank", 400, player, "kpmain.paladin"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "null"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "null"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "&1&lCommander Rank", 1000, player, "null"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "null"));
        } else if (!player.hasPermission("kpmain.captain")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "kpmain.squire"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "kpmain.knight"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPaladin Rank", 400, player, "kpmain.paladin"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "kpmain.captain"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "null"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "&1&lCommander Rank", 1000, player, "null"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "null"));
        } else if (!player.hasPermission("kpmain.lieutenant")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "kpmain.squire"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "kpmain.knight"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPaladin Rank", 400, player, "kpmain.paladin"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "kpmain.captain"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "kpmain.lieutenant"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "&1&lCommander Rank", 1000, player, "null"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "null"));
        } else if (!player.hasPermission("kpmain.commander")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "kpmain.squire"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "kpmain.knight"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPaladin Rank", 400, player, "kpmain.paladin"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "kpmain.captain"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "kpmain.lieutenant"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "&1&lCommander Rank", 1000, player, "kpmain.commander"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "null"));
        } else if (!player.hasPermission("kpmain.general")) {
            inv.setItem(0, createRankItem(Material.IRON_INGOT, "&f&lPage Rank", 400, player, "kpmain.page"));
            inv.setItem(1, createRankItem(Material.REDSTONE, "&c&lSquire Rank", 400, player, "kpmain.squire"));
            inv.setItem(2, createRankItem(Material.LAPIS_LAZULI, "&9&lKnight Rank", 400, player, "kpmain.knight"));
            inv.setItem(3, createRankItem(Material.LIME_DYE, "&a&lPaladin Rank", 400, player, "kpmain.paladin"));
            inv.setItem(4, createRankItem(Material.GREEN_DYE, "&2&lCaptain Rank", 400, player, "kpmain.captain"));
            inv.setItem(5, createRankItem(Material.LIGHT_BLUE_DYE, "&b&lLieutenant Rank", 500, player, "kpmain.lieutenant"));
            inv.setItem(6, createRankItem(Material.BLUE_DYE, "&1&lCommander Rank", 1000, player, "kpmain.commander"));
            inv.setItem(7, createRankItem(Material.EMERALD, "&a&lGeneral Rank", 500, player, "kpmain.general"));
        }
        inv.setItem(8, createGoBack());
        player.openInventory(inv);
    }

    private static ItemStack createRankItem(Material material, String displayName, int tokens, Player player, String rank) {
        ItemStack rankItem = new ItemStack(material);
        ItemMeta meta = rankItem.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        if (rank.equals("null")) {
            meta.setLore(Collections.singletonList(ChatColor.GRAY + "Follow the Rank Path!"));
        } else if (player.hasPermission(rank)) {
            meta.setLore(Collections.singletonList(ChatColor.GRAY + "Already own this rank."));
        } else {
            meta.setLore(Collections.singletonList(ChatColor.GRAY + "Tokens: " + ChatColor.YELLOW + tokens));
        }
        rankItem.setItemMeta(meta);
        return rankItem;
    }

    public static ItemStack createGoBack() {
        ItemStack goBack = new ItemStack(Material.BARRIER);
        ItemMeta meta = goBack.getItemMeta();
        meta.setDisplayName("Go Back");
        goBack.setItemMeta(meta);
        return goBack;
    }
}
