package me.bandithello.kpcore.Listeners;

import me.bandithello.kpcore.Database.CoinChanger;
import me.bandithello.kpcore.GUI.CommandGUI;
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

public class CommandListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String inventoryTitle = event.getView().getTitle();
        if (inventoryTitle.startsWith(ChatColor.BLACK + "KP Command Shop")) {
            event.setCancelled(true);
            CoinChanger coinChanger = new CoinChanger();
            String playerName = player.getName();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() == Material.FEATHER && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLACK + "Utopia Commands Shop"))
                    CommandGUI.OpenGUI(player);
                if (event.getCurrentItem().getType() == Material.FEATHER && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/fly")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.fly")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.fly.safelogin true";
                        String command2 = "lp user " + playerName + " permission set essentials.fly true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command2);
                        player.sendMessage("You just bought /fly");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.REDSTONE && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/nick (Colors)")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.nick.color")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.nick.color true";
                        String command2 = "lp user " + playerName + " permission set essentials.nick true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command2);
                        player.sendMessage("You just bought /nick with colors");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.INK_SAC && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/nick (No Colors)")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.nick")) {
                        player.sendMessage("Already own this rank.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.nick true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /nick");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.ANVIL && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/fix")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.repair")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.repair true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /fix");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.CHEST && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/fix all")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.repair.all")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.repair.all true";
                        String command2 = "lp user " + playerName + " permission set essentials.repair true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command2);
                        player.sendMessage("You just bought /fix all");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.DIAMOND_HELMET && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/hat")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.hat")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.hat true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /hat");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.CLOCK && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/ptime")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.ptime")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.ptime true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /ptime");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.WHITE_WOOL && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/pweather")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.pweather")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.pweather true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /pweather");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.GOLDEN_APPLE && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/heal")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.heal")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.heal true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /heal");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.BREAD && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/feed")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.feed")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.feed true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /feed");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.CRAFTING_TABLE && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/craft (Comes with /anvil)")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.workbench")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.workbench true";
                        String command2 = "lp user " + playerName + " permission set essentials.anvil true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command2);
                        player.sendMessage("You just bought /craft and /anvil");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.ENDER_CHEST && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/enderchest")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (player.hasPermission("essentials.enderchest")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.enderchest true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        player.sendMessage("You just bought /ec");
                        TokenGUI.openGUI(player);
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "/enderchest")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 500;
                    if (player.hasPermission("essentials.skull")) {
                        player.sendMessage("Already own this command.");
                    } else if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        String command = "lp user " + playerName + " permission set essentials.skull true";
                        String command2 = "lp user " + playerName + " permission set essentials.skull.others true";
                        String command3 = "lp user " + playerName + " permission set essentials.skull.spawn true";
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command);
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command2);
                        Bukkit.getServer().dispatchCommand((CommandSender)console, command3);
                        player.sendMessage("You just bought /skull");
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
