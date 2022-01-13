package market.entity;

@FunctionalInterface
public interface EntityId<Id> {
    Id getId();

    /*
    Java Generics Naming Convention
E - Element (used extensively by the Java Collections Framework)
K - Key.
N - Number.
T - Type.
V - Value.
S,U,V etc. - 2nd, 3rd, 4th types.
     */
}
