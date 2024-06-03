package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers3 {

    private final String a;
    private final String b;
    private final String c;

    public Headers3(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public <A, B, C> Where3<A, B, C> are(A a, B b, C c) {
        List<Row3<A, B, C>> rows = new ArrayList<>();
        rows.add(new Row3<>(a, b, c));
        return new Where3<>(this, rows);
    }

}
