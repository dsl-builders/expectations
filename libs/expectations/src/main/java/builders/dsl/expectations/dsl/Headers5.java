package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers5 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public Headers5(String a, String b, String c, String d, String e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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

    public <A, B, C, D, E> Where5<A, B, C, D, E> are(A a, B b, C c, D d, E e) {
        List<Row5<A, B, C, D, E>> rows = new ArrayList<>();
        rows.add(new Row5<>(a, b, c, d, e));
        return new Where5<>(this, rows);
    }

}