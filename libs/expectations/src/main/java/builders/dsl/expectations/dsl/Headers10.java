package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers10 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;

    public Headers10(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
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

    public String getI() {
        return i;
    }

    public String getJ() {
        return j;
    }

    public <A, B, C, D, E, F, G, H, I, J> Where10<A, B, C, D, E, F, G, H, I, J> are(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        List<Row10<A, B, C, D, E, F, G, H, I, J>> rows = new ArrayList<>();
        rows.add(new Row10<>(a, b, c, d, e, f, g, h, i, j));
        return new Where10<>(this, rows);
    }

}