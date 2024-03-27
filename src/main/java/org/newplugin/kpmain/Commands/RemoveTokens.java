package org.newplugin.kpmain.Commands;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.newplugin.kpmain.Database.CoinChanger;
import org.newplugin.kpmain.Database.CoinLister;
import org.newplugin.kpmain.Database.MySQLConnection;

public class RemoveTokens implements CommandExecutor {
    private Logger logger;

    private final MySQLConnection mySQLConnection;

    public RemoveTokens(Logger logger, MySQLConnection mySQLConnection) {
        this.logger = logger;
        this.mySQLConnection = mySQLConnection;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("Usage: /removetokens [playerName] <amount>");
            return true;
        }
        String playerName = args[0];
        this.logger.info("This is the player name: " + playerName);
        int balance = CoinLister.Check(playerName);
        this.logger.info("This is the player's current Balance: " + balance);
        if (args.length < 2) {
            sender.sendMessage("Usage: /removetokens [playerName] <amount>");
            return true;
        }
        try {
            int amount = Integer.parseInt(args[1]);
            if (balance < amount) {
                sender.sendMessage("Player does not have enough tokens for this.");
                return true;
            }
            sender.sendMessage("[Tokens] Removing $" + amount + " from " + playerName + "'s balance");
            CoinChanger Data = new CoinChanger();
            Data.remove(playerName, amount);
        } catch (NumberFormatException e) {
            sender.sendMessage("[Tokens] The second argument must be a valid number.");
            sender.sendMessage("[Tokens] Usage: /removetokens [playerName] <amount>");
        }
        return true;
    }
}
