package com.mysportsstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            
                // Retrieve environment variables with default fallback values
            String jdbcHost = System.getenv().getOrDefault("MYSQL_HOST", "localhost");
            String jdbcPort = System.getenv().getOrDefault("MYSQL_PORT", "3306");
            String jdbcDatabase = System.getenv().getOrDefault("MYSQL_DATABASE", "mysportsonlinestore");

            // Construct the JDBC URL
            String jdbcURL = "jdbc:mysql://" + jdbcHost + ":" + jdbcPort + "/" + jdbcDatabase;

            // Use root credentials set via MYSQL_ROOT_PASSWORD
            String jdbcUsername = "root";
            String jdbcPassword = System.getenv().getOrDefault("MYSQL_ROOT_PASSWORD", "root");

            // Establish the connection
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return connection;
}
}
