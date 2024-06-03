package builders.dsl.expectations.dsl;

import java.util.ArrayList;
import java.util.List;

public class Headers1 {

    private final String a;

    public Headers1(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public <A> Where1<A> is(A a) {
        List<Row1<A>> rows = new ArrayList<>();
        rows.add(new Row1<>(a));
        return new Where1<>(this, rows);
    }

}