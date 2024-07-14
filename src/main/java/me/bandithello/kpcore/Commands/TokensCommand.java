package me.bandithello.kpcore.Commands;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.bandithello.kpcore.Database.MySQLConnection;
import me.bandithello.kpcore.GUI.TokenGUI;

public class TokensCommand implements CommandExecutor {
    private Logger logger;

    private MySQLConnection mySQLConnection;

    public TokensCommand(Logger logger, MySQLConnection mySQLConnection) {
        this.logger = logger;
        this.mySQLConnection = mySQLConnection;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            TokenGUI.openGUI(player);
        } else {
            this.logger.warning("This command can only be used by a player");
        }
        return true;
    }
}
