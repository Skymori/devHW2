package market.service;

import market.entity.Product;
import market.repository.ShopStorage;

// please delete unused imports✅
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductBucketTest {
    private ProductBucket productBucket;

    //is the method used?✅
    private void testCalculateCoast(double expectedValue, String productId) {
        double accuracy = 0.001;
        assertEquals(expectedValue, productBucket.calculateCoast(productId), accuracy);
    }

    private void testCalculateCoastNegative(String productId) {
        assertThrows(NullPointerException.class, () -> productBucket.calculateCoast(productId), "Check you bucket");
    }

    @BeforeEach
    void setUp() {
        ShopStorage shopStorage = Mockito.mock(ShopStorage.class);
        //do we need mock with any? ✅
        Mockito.when(shopStorage.findById("A")).thenReturn(Optional.of(new Product("A", 1.25, 3, 3.0)));
        Mockito.when(shopStorage.findById("B")).thenReturn(Optional.of(new Product("B", 4.25)));
        Mockito.when(shopStorage.findById("C")).thenReturn(Optional.of(new Product("C", 1.0, 7, 5.0)));
        Mockito.when(shopStorage.findById("D")).thenReturn(Optional.of(new Product("D", 0.75)));
        this.productBucket = new ProductBucket(shopStorage);

    }

    //what do we test? The application should calculate prise for different type of products
    @Test
    void testCalculateCoastNull() {
        testCalculateCoastNegative(null);
    }

    @Test
    void testCalculateCoastEmpty() {
        testCalculateCoastNegative(" ");
    }

    @Test
    void testCalculateTotalCoast(){
        testCalculateCoast(7.25,"ABCD");
    }
    @Test
    void testCalculateLouCase(){
        testCalculateCoast(4.0, "aaCA");
    }

}