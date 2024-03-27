package org.newplugin.kpmain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.newplugin.kpmain.Commands.GiveTokens;
import org.newplugin.kpmain.Commands.RemoveTokens;
import org.newplugin.kpmain.Commands.TokensBalance;
import org.newplugin.kpmain.Commands.TokensCommand;
import org.newplugin.kpmain.Database.MySQLConnection;
import org.newplugin.kpmain.Events.CustomOnPlayerJoin;
import org.newplugin.kpmain.Listeners.ClaimsListener;
import org.newplugin.kpmain.Listeners.CommandListener;
import org.newplugin.kpmain.Listeners.KeysListener;
import org.newplugin.kpmain.Listeners.MainListener;
import org.newplugin.kpmain.Listeners.PhysicalListener;
import org.newplugin.kpmain.Listeners.RanksListener;

public final class KPMain extends JavaPlugin implements Listener {
    private MySQLConnection mySQLConnection;

    public static final String GIVE_TOKENS = "kpmain.givetokens";

    public static final String ZIRCON_RANK = "kpmain.zircon";

    public static final String RUBY_RANK = "kpmain.ruby";

    public static final String SAPPHIRE_RANK = "kpmain.sapphire";

    public static final String PERIDOT_RANK = "kpmain.peridot";

    public static final String TURQUOISE_RANK = "kpmain.turquoise";

    public static final String JADE_RANK = "kpmain.jade";

    public static final String HELENITE_RANK = "kpmain.helenite";

    public static final String EMERALD_RANK = "kpmain.emerald";

    private long breakDelay = 5L;

    private long decayDelay = 2L;

    private final List<Block> scheduledBlocks = new ArrayList<>();

    public void onEnable() {
        this.mySQLConnection = new MySQLConnection();
        getCommand("tokens").setExecutor((CommandExecutor)new TokensCommand(getLogger(), this.mySQLConnection));
        getCommand("givetokens").setExecutor((CommandExecutor)new GiveTokens(getLogger(), this.mySQLConnection));
        getCommand("tokenbal").setExecutor((CommandExecutor)new TokensBalance(getLogger(), this.mySQLConnection));
        getCommand("removetokens").setExecutor((CommandExecutor)new RemoveTokens(getLogger(), this.mySQLConnection));
        Bukkit.getPluginManager().registerEvents((Listener)new RanksListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new ClaimsListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new MainListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new KeysListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new CommandListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new CustomOnPlayerJoin(getLogger(), this.mySQLConnection), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PhysicalListener(), (Plugin)this);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onBlockBreak(BlockBreakEvent event) {
        onBlockRemove(event.getBlock(), this.breakDelay);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onLeavesDecay(LeavesDecayEvent event) {
        onBlockRemove(event.getBlock(), this.decayDelay);
    }

    private void onBlockRemove(Block oldBlock, long delay) {
        if (!Tag.LOGS.isTagged((Material) oldBlock.getType()) && !Tag.LEAVES.isTagged((Material) oldBlock.getType()))
            return;
        Collections.shuffle(NEIGHBORS);
        for (BlockFace neighborFace : NEIGHBORS) {
            Block block = oldBlock.getRelative(neighborFace);
            if (!Tag.LEAVES.isTagged((Material) block.getType()))
                continue;
            Leaves leaves = (Leaves)block.getBlockData();
            if (leaves.isPersistent())
                continue;
            if (this.scheduledBlocks.contains(block))
                continue;
            getServer().getScheduler().runTaskLater((Plugin)this, () -> decay(block), delay);
            this.scheduledBlocks.add(block);
        }
    }

    private boolean decay(Block block) {
        if (!this.scheduledBlocks.remove(block))
            return false;
        if (!block.getWorld().isChunkLoaded(block.getX() >> 4, block.getZ() >> 4))
            return false;
        if (!Tag.LEAVES.isTagged((Material) block.getType()))
            return false;
        Leaves leaves = (Leaves)block.getBlockData();
        if (leaves.isPersistent())
            return false;
        if (leaves.getDistance() < 7)
            return false;
        LeavesDecayEvent event = new LeavesDecayEvent(block);
        getServer().getPluginManager().callEvent((Event)event);
        if (event.isCancelled())
            return false;
        block.getWorld().spawnParticle(Particle.BLOCK_DUST, block.getLocation().add(0.5D, 0.5D, 0.5D), 8, 0.2D, 0.2D, 0.2D, 0.0D, block.getType().createBlockData());
        block.getWorld().playSound(block.getLocation(), Sound.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 0.05F, 1.2F);
        block.breakNaturally();
        return true;
    }

    private static final List<BlockFace> NEIGHBORS = Arrays.asList(new BlockFace[] { BlockFace.UP, BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.DOWN });

    public void onDisable() {}
}
