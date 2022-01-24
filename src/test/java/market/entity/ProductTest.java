package market.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void testSetUp() {
        product = new Product("B", 1.00, 6, 5.0);
    }

    //please read about test naming convention ✅
    @Test
    void testGetPrice() {
        double accuracy = 0.001;
        assertEquals(5.0, product.getPrice(6L), accuracy);
    }

    @Test
    void testShouldRuntimeExceptionWithMinusQuantity(){
        negativeTestCalculateCost(-5L, "minus value is invalid");
    }
    @Test
    void testShouldRuntimeExceptionWithNullQuantity(){
        negativeTestCalculateCost(null, "null is invalid");
    }
    private void negativeTestCalculateCost(Long quantity, String exceptionMessage) {
        assertThrows(RuntimeException.class, () -> product.getPrice(quantity), exceptionMessage);
    }
}