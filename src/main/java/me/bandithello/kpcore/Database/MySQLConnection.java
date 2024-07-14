package me.bandithello.kpcore.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private Connection connection;

    public MySQLConnection() {
        String host = "";
        String database = "";
        String username = "";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + database + "?useSSL=false";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException|ClassNotFoundException e) {
            e.getStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed())
                this.connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
