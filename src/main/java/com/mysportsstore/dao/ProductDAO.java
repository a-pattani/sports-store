package com.mysportsstore.dao;

import com.mysportsstore.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    // Use environment variables for the database connection
    private String jdbcURL = "jdbc:mysql://" + System.getenv().getOrDefault("MYSQL_HOST", "localhost") + ":" + System.getenv().getOrDefault("MYSQL_PORT", "3306") + "/" + System.getenv().getOrDefault("MYSQL_DATABASE", "mysportsonlinestore");
    private String jdbcUsername = System.getenv().getOrDefault("MYSQL_USER", "root");
    private String jdbcPassword = System.getenv().getOrDefault("MYSQL_PASSWORD", "root");

    // private String jdbcURL = "jdbc:mysql://localhost:3306/mysportsonlinestore";
    // private String jdbcUsername = "root";
    // private String jdbcPassword = "root";

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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        System.out.println("Starting to fetch products from the database...");
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
            
            rs.close();
            stmt.close();
            System.out.println("Products fetched successfully, number of products: " + products.size());
        } catch (Exception e) {
            System.err.println("Error fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
}
