package com.mysportsstore.dao;

import com.mysportsstore.model.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    private static ProductDAO productDAO;

    @BeforeAll
    static void setup() throws Exception {
        // Initialize ProductDAO
        productDAO = new ProductDAO();

        // Set up test database with sample data
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysportsonlinestore", "root", "root");
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS productstest (id INT AUTO_INCREMENT, name VARCHAR(255), description VARCHAR(255), price DOUBLE, PRIMARY KEY (id))");
            statement.execute("INSERT INTO productstest (name, description, price) VALUES ('Football', 'High-quality football', 29.99)");
        }
    }

    @AfterAll
    static void teardown() throws Exception {
        // Clean up test database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysportsonlinestore", "root", "root");
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS productstest");
        }
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertEquals("Football", products.get(0).getName());
    }
}
