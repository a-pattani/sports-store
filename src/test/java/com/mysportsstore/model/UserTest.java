package com.mysportsstore.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testDefaultConstructor() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    void testParameterizedConstructor() {
        User user = new User(1, "john_doe", "password123", "john@example.com");
        assertEquals(1, user.getId());
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    void testSettersAndGetters() {
        User user = new User();
        user.setId(2);
        user.setUsername("jane_doe");
        user.setPassword("securePass456");
        user.setEmail("jane@example.com");

        assertEquals(2, user.getId());
        assertEquals("jane_doe", user.getUsername());
        assertEquals("securePass456", user.getPassword());
        assertEquals("jane@example.com", user.getEmail());
    }
}
