package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers2 {

    private final String a;
    private final String b;

    public Headers2(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public <A, B> Where2<A, B> are(A a, B b) {
        List<Row2<A, B>> rows = new ArrayList<>();
        rows.add(new Row2<>(a, b));
        return new Where2<>(this, rows);
    }

}