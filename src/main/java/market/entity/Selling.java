package market.entity;

@FunctionalInterface
public interface Selling {
    Double getPrice(Long quantity);
}
