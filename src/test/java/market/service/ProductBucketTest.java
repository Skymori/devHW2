package market.service;

import market.entity.Product;
import market.repository.ShopStorage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductBucketTest {
    private final double accuracy = 0.001;
    private ProductBucket productBucket;

    private void testCalculateCoast(double expectedValue, String productId) {
        assertEquals(expectedValue, productBucket.calculateCoast(productId), accuracy);
    }

    private void testCalculateCoastNegative(String productId, String exceptionMessage) {
        assertThrows(NullPointerException.class, () -> productBucket.calculateCoast(productId), exceptionMessage);
    }

    @BeforeEach
    void setUp() {
        ShopStorage shopStorage = Mockito.mock(ShopStorage.class);
        Mockito.when(shopStorage.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(shopStorage.findById("A")).thenReturn(Optional.of(new Product("A",1.25,3,3.0)));
        Mockito.when(shopStorage.findById("B")).thenReturn(Optional.of(new Product("B",4.25)));
        Mockito.when(shopStorage.findById("C")).thenReturn(Optional.of(new Product("C", 1.0, 6, 5.0)));
        Mockito.when(shopStorage.findById("D")).thenReturn(Optional.of(new Product("D", 0.75)));
        this.productBucket =new ProductBucket(shopStorage);

    }


    @Test
    void calculateCoastNullOrEmpty() {
        testCalculateCoastNegative(null, "Check you bucket");
        testCalculateCoastNegative(" ","Check you bucket");
    }


}