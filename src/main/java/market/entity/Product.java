package market.entity;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Product implements EntityId<String>, Selling {
    String Id;
    Double productPiece;
    Integer productSaleQuantity;
    Double saleProductPrice;

    public Product(String productId, Double productPiece) {
        this(productId, productPiece, null, null);
    }

    @Override
    public Double getPrice(Long quantity) {
        if (quantity == null || quantity < 1) throw new RuntimeException("Bucket is Empty");
        if (productPiece == null) throw new NullPointerException("Product price null");
        return productSaleQuantity == null ? quantity * productPiece
                : (quantity / productSaleQuantity) * saleProductPrice + (quantity % productSaleQuantity) * productPiece;
    }
}
