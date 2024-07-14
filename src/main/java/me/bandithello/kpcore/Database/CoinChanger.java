package me.bandithello.kpcore.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoinChanger {
    private MySQLConnection mySQLConnection = new MySQLConnection();

    private void executeUpdate(String playerName, int coins, int operation) {
        try {
            Connection connection = this.mySQLConnection.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Test1 SET coins = coins " + (

                        (operation == 0) ? "+" : ((operation == 1) ? "-" : "")) + " ? WHERE name = ?");
                try {
                    preparedStatement.setInt(1, coins);
                    preparedStatement.setString(2, playerName);
                    preparedStatement.executeUpdate();
                    if (preparedStatement != null)
                        preparedStatement.close();
                } catch (Throwable throwable) {
                    if (preparedStatement != null)
                        try {
                            preparedStatement.close();
                        } catch (Throwable throwable1) {
                            throwable.addSuppressed(throwable1);
                        }
                    throw throwable;
                }
                if (connection != null)
                    connection.close();
            } catch (Throwable throwable) {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (Throwable throwable1) {
                        throwable.addSuppressed(throwable1);
                    }
                throw throwable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(String playerName, int coins) {
        executeUpdate(playerName, coins, 0);
    }

    public void set(String playerName, int newCoins) {
        try {
            Connection connection = this.mySQLConnection.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Test1 SET coins = ? WHERE name = ?");
                try {
                    preparedStatement.setInt(1, newCoins);
                    preparedStatement.setString(2, playerName);
                    preparedStatement.executeUpdate();
                    if (preparedStatement != null)
                        preparedStatement.close();
                } catch (Throwable throwable) {
                    if (preparedStatement != null)
                        try {
                            preparedStatement.close();
                        } catch (Throwable throwable1) {
                            throwable.addSuppressed(throwable1);
                        }
                    throw throwable;
                }
                if (connection != null)
                    connection.close();
            } catch (Throwable throwable) {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (Throwable throwable1) {
                        throwable.addSuppressed(throwable1);
                    }
                throw throwable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(String playerName, int coinsToRemove) {
        executeUpdate(playerName, coinsToRemove, 1);
    }
}
