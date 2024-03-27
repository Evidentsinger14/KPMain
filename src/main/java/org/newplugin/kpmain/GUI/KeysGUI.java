package org.newplugin.kpmain.GUI;

import java.util.Collections;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KeysGUI {
    public static void OpenGUI(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)player, 9, ChatColor.BLACK + "KP Keys Menu");
        inv.setItem(0, createSpawnerItem(Material.TRIPWIRE_HOOK, "1x God Crate Key", 1000, player));
        inv.setItem(1, createSpawnerItem(Material.TRIPWIRE_HOOK, "5x God Crate Keys", 4500, player));
        inv.setItem(2, createSpawnerItem(Material.TRIPWIRE_HOOK, "10x God Crate Keys", 8000, player));
        inv.setItem(3, createSpawnerItem(Material.TRIPWIRE_HOOK, "1x Spawner Crate Key", 500, player));
        inv.setItem(4, createSpawnerItem(Material.TRIPWIRE_HOOK, "5x Spawner Crate Keys", 2500, player));
        inv.setItem(5, createSpawnerItem(Material.TRIPWIRE_HOOK, "10x Spawner Crate Keys", 4500, player));
        inv.setItem(8, RanksGUI.createGoBack());
        player.openInventory(inv);
    }

    private static ItemStack createSpawnerItem(Material material, String displayName, int tokens, Player player) {
        ItemStack spawnerItem = new ItemStack(material);
        ItemMeta meta = spawnerItem.getItemMeta();
        meta.setDisplayName(ChatColor.BOLD + displayName);
        meta.setLore(Collections.singletonList(ChatColor.GRAY + "Tokens: " + ChatColor.YELLOW + tokens));
        spawnerItem.setItemMeta(meta);
        return spawnerItem;
    }
}
