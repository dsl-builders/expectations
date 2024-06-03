package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers7 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    public Headers7(String a, String b, String c, String d, String e, String f, String g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
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

    public <A, B, C, D, E, F, G> Where7<A, B, C, D, E, F, G> are(A a, B b, C c, D d, E e, F f, G g) {
        List<Row7<A, B, C, D, E, F, G>> rows = new ArrayList<>();
        rows.add(new Row7<>(a, b, c, d, e, f, g));
        return new Where7<>(this, rows);
    }

}