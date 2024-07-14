package me.bandithello.kpcore.Listeners;

import me.bandithello.kpcore.Database.CoinChanger;
import me.bandithello.kpcore.GUI.TokenGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.bandithello.kpcore.Database.CoinLister;

public class PhysicalListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String inventoryTitle = event.getView().getTitle();
        if (inventoryTitle.startsWith(ChatColor.BLACK + "KP Physical Tokens")) {
            event.setCancelled(true);
            ItemStack Physical1 = new ItemStack(Material.SUNFLOWER, 1);
            ItemStack Physical5 = new ItemStack(Material.SUNFLOWER, 5);
            ItemStack Physical10 = new ItemStack(Material.SUNFLOWER, 10);
            ItemMeta Physical1Meta = Physical1.getItemMeta();
            if (Physical1Meta != null) {
                Physical1Meta.setDisplayName(ChatColor.GOLD + "Physical Token");
                Physical1.setItemMeta(Physical1Meta);
            }
            ItemMeta Physical5Meta = Physical5.getItemMeta();
            if (Physical5Meta != null) {
                Physical5Meta.setDisplayName(ChatColor.GOLD + "Physical Token");
                Physical5.setItemMeta(Physical1Meta);
            }
            ItemMeta Physical10Meta = Physical10.getItemMeta();
            if (Physical10Meta != null) {
                Physical10Meta.setDisplayName(ChatColor.GOLD + "Physical Token");
                Physical10.setItemMeta(Physical1Meta);
            }
            CoinChanger coinChanger = new CoinChanger();
            String playerName = player.getName();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() == Material.SUNFLOWER && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "1 Physical Token")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 100;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        player.getInventory().addItem(new ItemStack[] { Physical1 });
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.SUNFLOWER && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "5 Physical Tokens")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 500;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        player.getInventory().addItem(new ItemStack[] { Physical5 });
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.SUNFLOWER && event
                        .getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "10 Physical Tokens")) {
                    int playerTokens = CoinLister.Check(playerName);
                    int coinsToRemove = 1000;
                    if (playerTokens >= coinsToRemove) {
                        coinChanger.remove(playerName, coinsToRemove);
                        player.getInventory().addItem(new ItemStack[] { Physical10 });
                    } else {
                        player.sendMessage("You do not have enough tokens for this!");
                    }
                }
                if (event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().getDisplayName().equals("Go Back"))
                    TokenGUI.openGUI(player);
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        String playerName = player.getName();
        if (event.getAction().toString().contains("RIGHT_CLICK") && event
                .getItem() != null && event
                .getItem().getType() == Material.SUNFLOWER && event
                .getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Physical Token")) {
            ItemStack mainHandItem = player.getInventory().getItemInMainHand();
            if (mainHandItem.getAmount() == 1) {
                CoinChanger coinchanger = new CoinChanger();
                coinchanger.add(playerName, 100);
                player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
            } else if (mainHandItem.getAmount() > 1) {
                mainHandItem.setAmount(mainHandItem.getAmount() - 1);
                CoinChanger coinchanger = new CoinChanger();
                coinchanger.add(playerName, 100);
            } else {
                player.sendMessage(ChatColor.RED + "You must have at least one Physical Token in your main hand to claim it.");
            }
        }
    }
}
