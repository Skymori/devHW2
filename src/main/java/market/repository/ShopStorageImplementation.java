package market.repository;

import market.entity.EntityId;
import market.entity.Selling;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
// ShopStorageImpl will be enough
// please be carefully with inheritance we should use it only for is-a relationships
// h
public class ShopStorageImplementation<T extends EntityId<Id> & Selling, Id> implements ShopStorage<T, Id> {
    private final Map<Id, T> productBucket;

    @SafeVarargs
    public ShopStorageImplementation(T... entities) {
        this.productBucket = Arrays
                .stream(entities)
                .collect(Collectors.toMap(EntityId::getId, v -> v));
    }

    @Override
    public Optional<T> findById(Id id) {
        final T entity = productBucket.get(id);
        return entity == null ? Optional.empty() : Optional.of(entity);
    }
}
