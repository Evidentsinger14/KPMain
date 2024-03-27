package org.newplugin.kpmain.GUI;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.newplugin.kpmain.Database.CoinLister;
import org.newplugin.kpmain.Database.MySQLConnection;

public class TokenGUI {
    private final Logger logger;

    private final MySQLConnection mySQLConnection;

    public TokenGUI(Logger logger, MySQLConnection mySQLConnection) {
        this.logger = logger;
        this.mySQLConnection = mySQLConnection;
    }

    public static void openGUI(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)player, 9, ChatColor.BLACK + "KP Tokens Menu");
        ItemStack glassPane = createTokenBal(player);
        ItemStack claimMenu = createMenuItem(Material.GOLDEN_SHOVEL, "&6&lClaimblock Shop");
        ItemStack rankMenu = createMenuItem(Material.IRON_INGOT, "&9&lRank Shop");
        ItemStack spawnerMenu = createMenuItem(Material.TRIPWIRE_HOOK, "&b&lCrate Shop");
        ItemStack commandMenu = createMenuItem(Material.FEATHER, "&f&lCommand Shop");
        ItemStack physicalMenu = createMenuItem(Material.SUNFLOWER, "&6&lTokens");
        inv.setItem(0, rankMenu);
        inv.setItem(1, claimMenu);
        inv.setItem(2, spawnerMenu);
        inv.setItem(3, commandMenu);
        inv.setItem(4, physicalMenu);
        inv.setItem(8, glassPane);
        player.openInventory(inv);
    }

    private static ItemStack createTokenBal(Player player) {
        ItemStack tokenBal = new ItemStack(Material.GLASS_PANE);
        ItemMeta meta = tokenBal.getItemMeta();
        String playerName = player.getName();
        int playerTokens = CoinLister.Check(playerName);
        meta.setDisplayName(ChatColor.GRAY + "Tokens: " + playerTokens);
        tokenBal.setItemMeta(meta);
        return tokenBal;
    }

    private static ItemStack createMenuItem(Material material, String displayName) {
        ItemStack menuItem = new ItemStack(material);
        ItemMeta meta = menuItem.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        menuItem.setItemMeta(meta);
        return menuItem;
    }
}
