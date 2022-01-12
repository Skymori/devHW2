package market.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;
    private final double accuracy = 0.001;
    @BeforeEach
    void setUp() {
        product = new Product("A", 1.25, 3,3.0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPrice() {
        assertEquals(3.0, product.getPrice(3L),accuracy);
    }

}