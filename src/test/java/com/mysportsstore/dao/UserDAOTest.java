package com.mysportsstore.dao;

import com.mysportsstore.dao.UserDAO;
import com.mysportsstore.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private static UserDAO userDAO;

    @BeforeAll
    static void setup() throws Exception {
        // Initialize UserDAO
        userDAO = new UserDAO();

        // Set up test database with sample data
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysportsonlinestore", "root", "root");
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT, username VARCHAR(255), password VARCHAR(255), email VARCHAR(255), PRIMARY KEY (id))");
            statement.execute("INSERT INTO users (username, password, email) VALUES ('john_doe', 'password123', 'john@example.com')");
        }
    }

    @AfterAll
    static void teardown() throws Exception {
        // Clean up test inserts
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysportsonlinestore", "root", "root");
             Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM users WHERE username IN ('jane_doe', 'john_doe') AND id > 0");
        }
    }

    @Test
    void testRegisterUser() throws Exception {
        User user = new User(0, "jane_doe", "securePass456", "jane@example.com");
        userDAO.registerUser(user);

        User registeredUser = userDAO.loginUser("jane_doe", "securePass456");
        assertNotNull(registeredUser);
        assertEquals("jane_doe", registeredUser.getUsername());
        assertEquals("jane@example.com", registeredUser.getEmail());
    }

    @Test
    void testLoginUser() {
        User user = userDAO.loginUser("john_doe", "password123");
        assertNotNull(user);
        assertEquals("john_doe", user.getUsername());
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    void testInvalidLogin() {
        User user = userDAO.loginUser("non_existent_user", "wrongpassword");
        assertNull(user, "User should be null for invalid login.");
    }
}
