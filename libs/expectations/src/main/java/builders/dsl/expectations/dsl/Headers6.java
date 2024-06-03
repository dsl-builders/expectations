package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers6 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    public Headers6(String a, String b, String c, String d, String e, String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getE() {
        return e;
    }

    public String getF() {
        return f;
    }

    public <A, B, C, D, E, F> Where6<A, B, C, D, E, F> are(A a, B b, C c, D d, E e, F f) {
        List<Row6<A, B, C, D, E, F>> rows = new ArrayList<>();
        rows.add(new Row6<>(a, b, c, d, e, f));
        return new Where6<>(this, rows);
    }

}