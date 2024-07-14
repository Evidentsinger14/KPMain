package me.bandithello.kpcore.Listeners;

import me.bandithello.kpcore.GUI.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        String inventoryTitle = event.getView().getTitle();
        Player player = (Player)event.getWhoClicked();
        if (inventoryTitle.equals(ChatColor.BLACK + "KP Tokens Menu")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType() == Material.GOLDEN_SHOVEL && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Claimblock Shop"))
                    ClaimblocksGUI.OpenGUI(player);
                if (event.getCurrentItem().getType() == Material.FEATHER && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "Command Shop"))
                    CommandGUI.OpenGUI(player);
                if (event.getCurrentItem().getType() == Material.IRON_INGOT && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE.toString() + ChatColor.BOLD.toString() + "Rank Shop"))
                    RanksGUI.OpenGUI(player);
                if (event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().getDisplayName().equals("Go Back"))
                    TokenGUI.openGUI(player);
                if (event.getCurrentItem().getType() == Material.GLASS_PANE && event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GRAY + "Tokens: ")) {
                    player.closeInventory();
                    player.sendMessage("You can buy more tokens at our store: Link");
                }
                if (event.getCurrentItem().getType() == Material.SUNFLOWER && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Tokens"))
                    PhysicalGUI.OpenGUI(player);
                if (event.getCurrentItem().getType() == Material.TRIPWIRE_HOOK && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Crate Shop"))
                    KeysGUI.OpenGUI(player);
            }
        }
    }
}
