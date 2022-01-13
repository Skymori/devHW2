package market.entity;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Product implements EntityId<String>, Selling {
    //variables shouldn't have Upper case in first letter
    String Id;
    Double productPiece;
    Integer productSaleQuantity;
    Double saleProductPrice;

    public Product(String productId, Double productPiece) {
        this(productId, productPiece, null, null);
    }

    @Override
    //what the reason to use Double instead of double?
    public Double getPrice(Long quantity) {
        // please NEVER use if statement without curly braces
        if (quantity == null || quantity < 1) throw new RuntimeException("Bucket is Empty");
        // the same
        if (productPiece == null) throw new NullPointerException("Product price null");

        return productSaleQuantity == null ? quantity * productPiece
                : (quantity / productSaleQuantity) * saleProductPrice + (quantity % productSaleQuantity) * productPiece;
    }
}
