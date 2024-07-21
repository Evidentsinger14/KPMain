package me.bandithello.kpcore;

import me.bandithello.kpcore.Commands.GiveTokens;
import me.bandithello.kpcore.Commands.RemoveTokens;
import me.bandithello.kpcore.Commands.TokensBalance;
import me.bandithello.kpcore.Commands.TokensCommand;
import me.bandithello.kpcore.Events.CustomOnPlayerJoin;
import org.bukkit.*;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import me.bandithello.kpcore.Database.MySQLConnection;

public final class KPMain extends JavaPlugin implements Listener {
    private MySQLConnection mySQLConnection;

    public void onEnable() {
        this.mySQLConnection = new MySQLConnection();
        registerCommands();
        Bukkit.getPluginManager().registerEvents(new CustomOnPlayerJoin(getLogger(), this.mySQLConnection), this);
    }
    public void onDisable() {

    }

    public void registerCommands(){
        getCommand("tokens").setExecutor(new TokensCommand(getLogger(), this.mySQLConnection));
        getCommand("givetokens").setExecutor(new GiveTokens(getLogger(), this.mySQLConnection));
        getCommand("tokenbal").setExecutor(new TokensBalance(getLogger(), this.mySQLConnection));
        getCommand("removetokens").setExecutor(new RemoveTokens(getLogger(), this.mySQLConnection));
    }
}
