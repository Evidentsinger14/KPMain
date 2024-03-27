package org.newplugin.kpmain.Commands;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.newplugin.kpmain.Database.CoinLister;
import org.newplugin.kpmain.Database.MySQLConnection;

public class TokensBalance implements CommandExecutor {
    private Logger logger;

    private final MySQLConnection mySQLConnection;

    public TokensBalance(Logger logger, MySQLConnection mySQLConnection) {
        this.logger = logger;
        this.mySQLConnection = mySQLConnection;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            String playerName = player.getName();
            int balance = CoinLister.Check(playerName);
            sender.sendMessage("Your balance is: " + balance);
        }
        return true;
    }
}
