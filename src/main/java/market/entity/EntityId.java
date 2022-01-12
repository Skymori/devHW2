package market.entity;

@FunctionalInterface
public interface EntityId<Id> {
    Id getId();
}
