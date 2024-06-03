package builders.dsl.expectations.dsl;

public class Row2<A, B> {

    private final A a;
    private final B b;

    public Row2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

}
