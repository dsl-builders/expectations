package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers4 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;

    public Headers4(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public <A, B, C, D> Where4<A, B, C, D> are(A a, B b, C c, D d) {
        List<Row4<A, B, C, D>> rows = new ArrayList<>();
        rows.add(new Row4<>(a, b, c, d));
        return new Where4<>(this, rows);
    }

}