package com.mysportsstore.dao;

import com.mysportsstore.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {


    private String jdbcURL = "jdbc:mysql://" + System.getenv().getOrDefault("MYSQL_HOST", "localhost") + ":" + System.getenv().getOrDefault("MYSQL_PORT", "3306") + "/" + System.getenv().getOrDefault("MYSQL_DATABASE", "mysportsonlinestore");
    private String jdbcUsername = System.getenv().getOrDefault("MYSQL_USER", "root");
    private String jdbcPassword = System.getenv().getOrDefault("MYSQL_PASSWORD", "root");

    // private String jdbcURL = "jdbc:mysql://localhost:3306/mysportsonlinestore";
    // private String jdbcUsername = "root";
    // private String jdbcPassword = "root";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (username, password, email) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT id, username, email FROM users WHERE username = ? and password = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void registerUser(User user) throws Exception {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User loginUser(String username, String password) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
