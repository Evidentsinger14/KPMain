package me.bandithello.kpcore.Commands;

import java.util.logging.Logger;

import me.bandithello.kpcore.Database.CoinChanger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.bandithello.kpcore.Database.CoinLister;
import me.bandithello.kpcore.Database.MySQLConnection;

public class GiveTokens implements CommandExecutor {
    private final Logger logger;

    private final MySQLConnection mySQLConnection;

    public GiveTokens(Logger logger, MySQLConnection mySQLConnection) {
        this.logger = logger;
        this.mySQLConnection = mySQLConnection;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) && !sender.equals(Bukkit.getConsoleSender())) {
            sender.sendMessage("This command can only be run by a player or the console.");
            return true;
        }
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (!player.hasPermission("kpmain.givetokens")) {
                sender.sendMessage("You do not have permission to run this command!");
                return true;
            }
        }
        if (args.length < 2) {
            sender.sendMessage("Usage: /givetokens [playerName] <amount>");
            return true;
        }
        String playerName = args[0];
        this.logger.info("Player name: " + playerName);
        int balance = CoinLister.Check(playerName);
        this.logger.info("Player's current balance: " + balance);
        try {
            int amount = Integer.parseInt(args[1]);
            sender.sendMessage("[Tokens] Adding " + amount + " to " + playerName + "'s balance");
            CoinChanger data = new CoinChanger();
            data.add(playerName, amount);
        } catch (NumberFormatException e) {
            sender.sendMessage("[Tokens] The third argument must be a valid number.");
            sender.sendMessage("[Tokens] Usage: /givetokens [playerName] <amount>");
        }
        return true;
    }
}
