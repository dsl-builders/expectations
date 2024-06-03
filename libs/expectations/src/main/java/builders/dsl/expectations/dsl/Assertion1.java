package builders.dsl.expectations.dsl;

@FunctionalInterface
public interface Assertion1<A> {

    boolean verify(A a);

}
