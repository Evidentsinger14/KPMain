package me.bandithello.kpcore.Events;

import me.bandithello.kpcore.Database.CoinChanger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CustomOnTokenClick {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
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
