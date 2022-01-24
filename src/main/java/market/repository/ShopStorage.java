package market.repository;

import market.entity.EntityId;

import java.util.Optional;

public interface ShopStorage <T extends EntityId<E>, E>{
    Optional<T> findById(E id);
}
