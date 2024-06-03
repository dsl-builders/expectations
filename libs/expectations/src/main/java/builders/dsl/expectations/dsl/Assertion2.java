package builders.dsl.expectations.dsl;

@FunctionalInterface
public interface Assertion2<A, B> {

    boolean verify(A a, B b);

}
