package market.service;

import market.entity.EntityId;
import market.entity.Selling;
import market.repository.ShopStorage;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ShopBucket <T extends EntityId<Id> & Selling, Id> {
    private final ShopStorage<T, Id> shopStorage;

    public ShopBucket(ShopStorage<T, Id> shopStorage) {
        this.shopStorage = shopStorage;
    }
    @SafeVarargs
    protected final double calculateCoast(Id... ids){
        final Map<Id, Long> quantity = Optional.ofNullable(ids).map(id -> Arrays.stream(id)
                .map(shopStorage::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.groupingBy(EntityId::getId,Collectors.counting())))
                .orElseThrow(() -> new NullPointerException("Empty bucket"));
        if (quantity.isEmpty()) throw new NullPointerException("Empty bucket");
        return quantity
                .entrySet()
                .stream()
                .mapToDouble(p -> shopStorage
                        .findById(p.getKey())
                        .get()
                        .getPrice(p.getValue()))
                .sum();
    }
}
