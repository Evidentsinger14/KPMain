package org.newplugin.kpmain.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private Connection connection;

    public MySQLConnection() {
        String host = "nexus.ev1dent.dev";
        String database = "s16_currency";
        String username = "u16_4Y9mxKR4JS";
        String password = "mAkOf@t9yroOMUT^^QLvU9WF";
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
