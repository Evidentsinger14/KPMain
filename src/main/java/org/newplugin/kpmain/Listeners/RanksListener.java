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
                if (event.getCurrentItem().getType() == Material.WHITE_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "Page Rank")) {
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
                } else if (event.getCurrentItem().getType() == Material.YELLOW_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "Squire Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.squire")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add Squire";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Squire rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.GREEN_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE.toString() + ChatColor.BOLD.toString() + "Knight Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.squire") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.knight")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add knight";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Knight rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.ORANGE_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Paladin Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.knight") ||
                            !player.hasPermission("kpmain.squire") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.paladin")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add paladin";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to paladin rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.BLUE_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD.toString() + "Captain Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 400;
                    if (!player.hasPermission("kpmain.paladin") ||
                            !player.hasPermission("kpmain.knight") ||
                            !player.hasPermission("kpmain.squire") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.captain")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add captain";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Captain rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.CYAN_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Lieutenant Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 500;
                    if (!player.hasPermission("kpmain.captain") ||
                            !player.hasPermission("kpmain.paladin") ||
                            !player.hasPermission("kpmain.knight") ||
                            !player.hasPermission("kpmain.squire") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.lieutenant")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add lieutenant";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Lieutenant rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.LIGHT_BLUE_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_BLUE.toString() + ChatColor.BOLD.toString() + "Commander Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (!player.hasPermission("kpmain.lieutenant") ||
                            !player.hasPermission("kpmain.captain") ||
                            !player.hasPermission("kpmain.paladin") ||
                            !player.hasPermission("kpmain.knight") ||
                            !player.hasPermission("kpmain.squire") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.commander")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add commander";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to Commander rank!");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                } else if (event.getCurrentItem().getType() == Material.BLACK_DYE && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "General Rank")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 500;
                    if (!player.hasPermission("kpmain.commander") ||
                            !player.hasPermission("kpmain.lieutenant") ||
                            !player.hasPermission("kpmain.captain") ||
                            !player.hasPermission("kpmain.paladin") ||
                            !player.hasPermission("kpmain.knight") ||
                            !player.hasPermission("kpmain.squire") ||
                            !player.hasPermission("kpmain.page")) {
                        player.closeInventory();
                        player.sendMessage("Follow the rank path!");
                    } else if (player.hasPermission("kpmain.general")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " parent add general";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You have just ranked up to General rank!");
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
