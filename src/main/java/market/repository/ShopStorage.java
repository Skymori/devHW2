package market.repository;

import market.entity.EntityId;

import java.util.Optional;

public interface ShopStorage <T extends EntityId<Id>,Id>{
    Optional<T> findById(Id id);
}
