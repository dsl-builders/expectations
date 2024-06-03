package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Where8<A, B, C, D, E, F, G, H> {

    private final List<Row8<A, B, C, D, E, F, G, H>> data = new ArrayList<>();
    private final Headers8 headers;

    public Where8(Headers8 headers, Iterable<Row8<A, B, C, D, E, F, G, H>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    public Expectations expect(String template, Assertion8<A, B, C, D, E, F, G, H> verification) {
        return new Expectations8<>(this, template, verification);
    }

    public Expectations verify(String template, Verification8<A, B, C, D, E, F, G, H> verification) {
        return new Expectations8<>(this, template, (a, b, c, d, e, f, g, h) -> {
            verification.verify(a, b, c, d, e, f, g, h);
            return true;
        });
    }

    public Where8<A, B, C, D, E, F, G, H> and(A a, B b, C c, D d, E e, F f, G g, H h) {
        data.add(new Row8<>(a, b, c, d, e, f, g, h));
        return this;
    }

    Stream<DynamicTest> generateTests(String template, Assertion8<A, B, C, D, E, F, G, H> verification) {
        return data.stream().map(row -> {
            String title = template.replace("#" + headers.getA(), String.valueOf(row.getA()));
            title = title.replace("#" + headers.getB(), String.valueOf(row.getB()));
            title = title.replace("#" + headers.getC(), String.valueOf(row.getC()));
            title = title.replace("#" + headers.getD(), String.valueOf(row.getD()));
            title = title.replace("#" + headers.getE(), String.valueOf(row.getE()));
            title = title.replace("#" + headers.getF(), String.valueOf(row.getF()));
            title = title.replace("#" + headers.getG(), String.valueOf(row.getG()));
            String finalTitle = title.replace("#" + headers.getH(), String.valueOf(row.getH()));
            return DynamicTest.dynamicTest(
                    finalTitle,
                    () -> {
                        if (!verification.verify(row.getA(), row.getB(), row.getC(), row.getD(), row.getE(), row.getF(), row.getG(), row.getH())) {
                            throw new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB() + ", " + headers.getC() + "=" + row.getC() + ", " + headers.getD() + "=" + row.getD() + ", " + headers.getE() + "=" + row.getE() + ", " + headers.getF() + "=" + row.getF() + ", " + headers.getG() + "=" + row.getG() + ", " + headers.getH() + "=" + row.getH());
                        }
                    });
        });
    }

}
