package market;

import market.entity.Product;
import market.repository.ShopStorageImplementation;
import market.service.ProductBucket;

public class Main {
    public static void main(String[] args) {
        ProductBucket productBucket = new ProductBucket(new ShopStorageImplementation<>(
                new Product("A", 1.25, 3, 3.0),
                new Product("B", 4.25),
                new Product("C", 1.0, 6, 5.0),
                new Product("D", 0.75)));
        double coast = productBucket.calculateCoast("AAA");
        System.out.println(coast);
    }
}
