package org.newplugin.kpmain.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.newplugin.kpmain.Database.CoinChanger;
import org.newplugin.kpmain.Database.CoinLister;
import org.newplugin.kpmain.GUI.TokenGUI;

public class RanksListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String inventoryTitle = event.getView().getTitle();
        if (inventoryTitle.equals(ChatColor.BLACK + "KP Ranks Menu")) {
            event.setCancelled(true);
            CoinChanger coinChanger = new CoinChanger();
            String playerName = player.getName();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() == Material.IRON_INGOT && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "Page Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (player.hasPermission("kpmain.page")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add page";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to page rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.REDSTONE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "Ruby Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.ruby")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add ruby";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Ruby rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.LAPIS_LAZULI && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE.toString() + ChatColor.BOLD.toString() + "Sapphire Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.ruby") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.sapphire")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add sapphire";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Sapphire rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.LIME_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Peridot Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.sapphire") ||
                            !player.hasPermission("kpmain.ruby") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.peridot")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add peridot";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Peridot rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.GREEN_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD.toString() + "Jade Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.peridot") ||
                            !player.hasPermission("kpmain.sapphire") ||
                            !player.hasPermission("kpmain.ruby") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.jade")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add jade";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Jade rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.LIGHT_BLUE_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Turquoise Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 500;
                    if (!player.hasPermission("kpmain.jade") ||
                            !player.hasPermission("kpmain.peridot") ||
                            !player.hasPermission("kpmain.sapphire") ||
                            !player.hasPermission("kpmain.ruby") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.turquoise")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add turquoise";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Turquoise rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.BLUE_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_BLUE.toString() + ChatColor.BOLD.toString() + "Helenite Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (!player.hasPermission("kpmain.turquoise") ||
                            !player.hasPermission("kpmain.jade") ||
                            !player.hasPermission("kpmain.peridot") ||
                            !player.hasPermission("kpmain.sapphire") ||
                            !player.hasPermission("kpmain.ruby") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.helenite")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add helenite";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Helenite rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.EMERALD && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Emerald Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 500;
                    if (!player.hasPermission("kpmain.helenite") ||
                            !player.hasPermission("kpmain.turquoise") ||
                            !player.hasPermission("kpmain.jade") ||
                            !player.hasPermission("kpmain.peridot") ||
                            !player.hasPermission("kpmain.sapphire") ||
                            !player.hasPermission("kpmain.ruby") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.emerald")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add emerald";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Emerald rank!");
                        player.sendMessage("Congrats! You have all the ranks!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().getDisplayName().equals("Go Back"))
                    TokenGUI.openGUI(player);
            }
        }
    }
}
