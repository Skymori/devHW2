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
        product = new Product("B", 1.00, 6,5.0);
    }

    @AfterEach
    void tearDown() {
    }

    //please read about test naming convention
    @Test
    void getPrice() {
        assertEquals(5.0, product.getPrice(6L),accuracy);
    }

}