package org.newplugin.kpmain.Events;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.newplugin.kpmain.Database.MySQLConnection;

public class CustomOnPlayerJoin implements Listener {
    private final Logger logger;

    private final MySQLConnection mySQLConnection;

    public CustomOnPlayerJoin(Logger logger, MySQLConnection mySQLConnection) {
        this.logger = logger;
        this.mySQLConnection = mySQLConnection;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        try {
            Connection connection = this.mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String checkQuery = "SELECT * FROM Test1 WHERE name = '" + playerName + "'";
            ResultSet checkResult = statement.executeQuery(checkQuery);
            if (checkResult.next()) {
                this.logger.info("Entry exists for: " + playerName);
            } else {
                String insertQuery = "INSERT INTO Test1 (name, coins) VALUES ('" + playerName + "', 0)";
                int rowsInserted = statement.executeUpdate(insertQuery);
                this.logger.info("Inserted " + rowsInserted + " row for: " + playerName + " with 0 coins");
                checkResult.close();
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.logger.info("Failed to execute the query for some reason???????");
        }
    }
}
