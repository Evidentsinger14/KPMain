package me.bandithello.kpcore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import me.bandithello.kpcore.Commands.GiveTokens;
import me.bandithello.kpcore.Commands.RemoveTokens;
import me.bandithello.kpcore.Commands.TokensBalance;
import me.bandithello.kpcore.Commands.TokensCommand;
import me.bandithello.kpcore.Events.CustomOnPlayerJoin;
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
import me.bandithello.kpcore.Database.MySQLConnection;
import me.bandithello.kpcore.Listeners.ClaimsListener;
import me.bandithello.kpcore.Listeners.CommandListener;
import me.bandithello.kpcore.Listeners.KeysListener;
import me.bandithello.kpcore.Listeners.MainListener;
import me.bandithello.kpcore.Listeners.PhysicalListener;
import me.bandithello.kpcore.Listeners.RanksListener;

public final class KPMain extends JavaPlugin implements Listener {
    private MySQLConnection mySQLConnection;

    public static final String GIVE_TOKENS = "kpmain.givetokens";

    public static final String PAGE_RANK = "kpmain.page";

    public static final String SQUIRE_RANK = "kpmain.squire";

    public static final String KNIGHT_RANK = "kpmain.knight";

    public static final String PALADIN_RANK = "kpmain.paladin";

    public static final String LIEUTENANT_RANK = "kpmain.lieutenant";

    public static final String CAPTAIN_RANK = "kpmain.captain";

    public static final String COMMANDER_RANK = "kpmain.commander";

    public static final String GENERAL_RANK = "kpmain.general";

    public static final String MARSHAL_RANK = "kpmain.marshal";

    public static final String CHAMPION_RANK = "kpmain.champion";

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
