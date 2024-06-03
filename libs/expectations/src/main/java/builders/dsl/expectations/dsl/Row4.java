package builders.dsl.expectations.dsl;

public class Row4<A, B, C, D> {

    private final A a;
    private final B b;
    private final C c;
    private final D d;

    public Row4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    public D getD() {
        return d;
    }

}
