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

public class KeysListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String inventoryTitle = event.getView().getTitle();
        if (inventoryTitle.equals(ChatColor.BLACK + "KP Keys Menu")) {
            event.setCancelled(true);
            CoinChanger coinChanger = new CoinChanger();
            String playerName = player.getName();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (!inventoryTitle.equals("Claimblocks"))
                if (event.getCurrentItem() != null) {
                    if (event.getCurrentItem().getType() == Material.TRIPWIRE_HOOK && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "1x God Crate Key")) {
                        int playerTokens = CoinLister.Check(playerName);
                        int coinsToRemove = 1000;
                        if (playerTokens >= coinsToRemove) {
                            coinChanger.remove(playerName, coinsToRemove);
                            String command = "cc give virtual OpGod 1 " + playerName;
                            Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                            TokenGUI.openGUI(player);
                        } else {
                            player.sendMessage("You do not have enough tokens for this!");
                        }
                    }
                    if (event.getCurrentItem().getType() == Material.TRIPWIRE_HOOK && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "1x Spawner Crate Key")) {
                        int playerTokens = CoinLister.Check(playerName);
                        int coinsToRemove = 500;
                        if (playerTokens >= coinsToRemove) {
                            coinChanger.remove(playerName, coinsToRemove);
                            String command = "cc give virtual Spawner 1 " + playerName;
                            Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                            TokenGUI.openGUI(player);
                        } else {
                            player.sendMessage("You do not have enough tokens for this!");
                        }
                    }
                    if (event.getCurrentItem().getType() == Material.TRIPWIRE_HOOK && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "5x God Crate Keys")) {
                        int playerTokens = CoinLister.Check(playerName);
                        int coinsToRemove = 4000;
                        if (playerTokens >= coinsToRemove) {
                            coinChanger.remove(playerName, coinsToRemove);
                            String command = "cc give virtual OpGod 5 " + playerName;
                            Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                            TokenGUI.openGUI(player);
                        } else {
                            player.sendMessage("You do not have enough tokens for this!");
                        }
                    }
                    if (event.getCurrentItem().getType() == Material.TRIPWIRE_HOOK && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "5x Spawner Crate Keys")) {
                        int playerTokens = CoinLister.Check(playerName);
                        int coinsToRemove = 2500;
                        if (playerTokens >= coinsToRemove) {
                            coinChanger.remove(playerName, coinsToRemove);
                            String command = "cc give virtual Spawner 5 " + playerName;
                            Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                            TokenGUI.openGUI(player);
                        } else {
                            player.sendMessage("You do not have enough tokens for this!");
                        }
                    }
                    if (event.getCurrentItem().getType() == Material.TRIPWIRE_HOOK && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "10x God Crate Keys")) {
                        int playerTokens = CoinLister.Check(playerName);
                        int coinsToRemove = 8000;
                        if (playerTokens >= coinsToRemove) {
                            coinChanger.remove(playerName, coinsToRemove);
                            String command = "cc give virtual OpGod 10 " + playerName;
                            Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                            TokenGUI.openGUI(player);
                        } else {
                            player.sendMessage("You do not have enough tokens for this!");
                        }
                    }
                    if (event.getCurrentItem().getType() == Material.TRIPWIRE_HOOK && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "10x Spawner Crate Keys")) {
                        int playerTokens = CoinLister.Check(playerName);
                        int coinsToRemove = 4500;
                        if (playerTokens >= coinsToRemove) {
                            coinChanger.remove(playerName, coinsToRemove);
                            String command = "cc give virtual Spawner 10 " + playerName;
                            Bukkit.getServer().dispatchCommand((CommandSender)console, command);
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
