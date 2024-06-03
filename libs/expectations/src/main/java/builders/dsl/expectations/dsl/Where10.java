package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Where10<A, B, C, D, E, F, G, H, I, J> {

    private final List<Row10<A, B, C, D, E, F, G, H, I, J>> data = new ArrayList<>();
    private final Headers10 headers;

    public Where10(Headers10 headers, Iterable<Row10<A, B, C, D, E, F, G, H, I, J>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    public Expectations expect(String template, Assertion10<A, B, C, D, E, F, G, H, I, J> verification) {
        return new Expectations10<>(this, template, verification);
    }

    public Expectations verify(String template, Verification10<A, B, C, D, E, F, G, H, I, J> verification) {
        return new Expectations10<>(this, template, (a, b, c, d, e, f, g, h, i, j) -> {
            verification.verify(a, b, c, d, e, f, g, h, i, j);
            return true;
        });
    }

    public Where10<A, B, C, D, E, F, G, H, I, J> and(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        data.add(new Row10<>(a, b, c, d, e, f, g, h, i, j));
        return this;
    }

    Stream<DynamicTest> generateTests(String template, Assertion10<A, B, C, D, E, F, G, H, I, J> verification) {
        return data.stream().map(row -> {
            String title = template.replace("#" + headers.getA(), String.valueOf(row.getA()));
            title = title.replace("#" + headers.getB(), String.valueOf(row.getB()));
            title = title.replace("#" + headers.getC(), String.valueOf(row.getC()));
            title = title.replace("#" + headers.getD(), String.valueOf(row.getD()));
            title = title.replace("#" + headers.getE(), String.valueOf(row.getE()));
            title = title.replace("#" + headers.getF(), String.valueOf(row.getF()));
            title = title.replace("#" + headers.getG(), String.valueOf(row.getG()));
            title = title.replace("#" + headers.getH(), String.valueOf(row.getH()));
            title = title.replace("#" + headers.getI(), String.valueOf(row.getI()));
            String finalTitle = title.replace("#" + headers.getJ(), String.valueOf(row.getJ()));
            return DynamicTest.dynamicTest(
                    finalTitle,
                    () -> {
                        if (!verification.verify(row.getA(), row.getB(), row.getC(), row.getD(), row.getE(), row.getF(), row.getG(), row.getH(), row.getI(), row.getJ())) {
                            throw new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB() + ", " + headers.getC() + "=" + row.getC() + ", " + headers.getD() + "=" + row.getD() + ", " + headers.getE() + "=" + row.getE() + ", " + headers.getF() + "=" + row.getF() + ", " + headers.getG() + "=" + row.getG() + ", " + headers.getH() + "=" + row.getH() + ", " + headers.getI() + "=" + row.getI() + ", " + headers.getJ() + "=" + row.getJ());
                        }
                    });
        });
    }

}