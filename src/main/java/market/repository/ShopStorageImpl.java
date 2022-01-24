package market.repository;

import market.entity.EntityId;
import market.entity.Selling;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
// ShopStorageImpl will be enough ✅
// please be carefully with inheritance we should use it only for is-a relationships ✅
// h
public class ShopStorageImpl<T extends EntityId<E> & Selling, E> implements ShopStorage<T, E> {
    private final Map<E, T> productBucket;

    @SafeVarargs
    public ShopStorageImpl(T... entities) {
        this.productBucket = Arrays
                .stream(entities)
                .collect(Collectors.toMap(EntityId::getId, v -> v));
    }

    @Override
    public Optional<T> findById(E e) {
        final T entity = productBucket.get(e);
        return entity == null ? Optional.empty() : Optional.of(entity);
    }
}
