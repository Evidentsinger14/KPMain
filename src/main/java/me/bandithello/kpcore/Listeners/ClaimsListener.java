package me.bandithello.kpcore.Listeners;

import me.bandithello.kpcore.Database.CoinChanger;
import me.bandithello.kpcore.GUI.TokenGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import me.bandithello.kpcore.Database.CoinLister;

public class ClaimsListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String inventoryTitle = event.getView().getTitle();
        if (inventoryTitle.startsWith(ChatColor.BLACK + "KP Claimblock Shop")) {
            event.setCancelled(true);
            CoinChanger coinChanger = new CoinChanger();
            String playerName = player.getName();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() == Material.GOLDEN_SHOVEL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "2000 Claimblocks")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 350;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "acb " + playerName + " 2000";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought 2000 Claimblocks");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.GOLDEN_SHOVEL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "5000 Claimblocks")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 700;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "acb " + playerName + " 5000";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought 5000 Claimblocks");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.GOLDEN_SHOVEL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "10000 Claimblocks")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1500;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "acb " + playerName + " 10000";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought 10000 Claimblocks");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.GOLDEN_SHOVEL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "20000 Claimblocks")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 2500;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "acb " + playerName + " 20000";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought 20000 Claimblocks");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.GOLDEN_SHOVEL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "40000 Claimblocks")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 5000;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "acb " + playerName + " 40000";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought 40000 Claimblocks");
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
