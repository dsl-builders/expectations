package builders.dsl.expectations.dsl;

@FunctionalInterface
public interface Assertion3<A, B, C> {

    boolean verify(A a, B b, C c);

}

