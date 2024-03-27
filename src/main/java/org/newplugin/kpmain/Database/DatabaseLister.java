package org.newplugin.kpmain.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLister {
    public static void createTable() {
        MySQLConnection mySQLConnection = new MySQLConnection();
        try {
            Connection connection = mySQLConnection.getConnection();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Test1 (id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(255) NOT NULL,value INT NOT NULL)";
            PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL);
            preparedStatement.executeUpdate();
            System.out.println("Table 'Test1' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTable();
    }
}
