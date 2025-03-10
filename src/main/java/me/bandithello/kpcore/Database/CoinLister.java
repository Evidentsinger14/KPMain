package me.bandithello.kpcore.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinLister {
    public static int Check(String searchName) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        int value = 1;
        try {
            Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT coins FROM Test1 WHERE name = ?");
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                value = resultSet.getInt("coins");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mySQLConnection.closeConnection();
        }
        return value;
    }
}
