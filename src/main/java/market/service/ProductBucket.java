package market.service;

import market.entity.Product;
import market.repository.ShopStorage;

import java.util.Optional;

public class ProductBucket extends ShopBucket<Product,String> {
    public ProductBucket(ShopStorage<Product,String> shopStorage){
        super(shopStorage);
    }

    //Any test for the method?✅
    public double calculateCoast(String args){
        return super.calculateCoast(Optional.ofNullable(args)
                .map(arg-> arg.toUpperCase().split(""))
                .orElse(null));
    }
}
