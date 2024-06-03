package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers8 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;

    public Headers8(String a, String b, String c, String d, String e, String f, String g, String h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
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

    public String getG() {
        return g;
    }

    public String getH() {
        return h;
    }

    public <A, B, C, D, E, F, G, H> Where8<A, B, C, D, E, F, G, H> are(A a, B b, C c, D d, E e, F f, G g, H h) {
        List<Row8<A, B, C, D, E, F, G, H>> rows = new ArrayList<>();
        rows.add(new Row8<>(a, b, c, d, e, f, g, h));
        return new Where8<>(this, rows);
    }

}