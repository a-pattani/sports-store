package com.mysportsstore.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testDefaultConstructor() {
        Product product = new Product();
        assertNotNull(product);
    }

    @Test
    void testParameterizedConstructor() {
        Product product = new Product(1, "Football", "A high-quality football", 29.99);
        assertEquals(1, product.getId());
        assertEquals("Football", product.getName());
        assertEquals("A high-quality football", product.getDescription());
        assertEquals(29.99, product.getPrice());
    }

    @Test
    void testSettersAndGetters() {
        Product product = new Product();
        product.setId(2);
        product.setName("Basketball");
        product.setDescription("An indoor/outdoor basketball");
        product.setPrice(19.99);

        assertEquals(2, product.getId());
        assertEquals("Basketball", product.getName());
        assertEquals("An indoor/outdoor basketball", product.getDescription());
        assertEquals(19.99, product.getPrice());
    }
}
