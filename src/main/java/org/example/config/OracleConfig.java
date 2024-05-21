package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConfig {
    private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static String user = "RM552648";
    private static String password = "160205";

    public Connection getConnection() {
        Connection connection = null;
        try {
            return DriverManager.getConnection(url, user,password);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
