package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Where5<A, B, C, D, E> {

            private final List<Row5<A, B, C, D, E>> data = new ArrayList<>();
            private final Headers5 headers;

            public Where5(Headers5 headers, Iterable<Row5<A, B, C, D, E>> rows) {
                this.headers = headers;
                rows.forEach(data::add);
            }

            public Expectations expect(String template, Assertion5<A, B, C, D, E> verification) {
                return new Expectations5<>(this, template, verification);
            }

            public Expectations verify(String template, Verification5<A, B, C, D, E> verification) {
                return new Expectations5<>(this, template, (a, b, c, d, e) -> {
                    verification.verify(a, b, c, d, e);
                    return true;
                });
            }

            public Where5<A, B, C, D, E> and(A a, B b, C c, D d, E e) {
                data.add(new Row5<>(a, b, c, d, e));
                return this;
            }

            Stream<DynamicTest> generateTests(String template, Assertion5<A, B, C, D, E> verification) {
                return data.stream().map(row -> {
                    String title = template.replace("#" + headers.getA(), String.valueOf(row.getA()));
                    title = title.replace("#" + headers.getB(), String.valueOf(row.getB()));
                    title = title.replace("#" + headers.getC(), String.valueOf(row.getC()));
                    title = title.replace("#" + headers.getD(), String.valueOf(row.getD()));
                    String finalTitle = title.replace("#" + headers.getE(), String.valueOf(row.getE()));
                    return DynamicTest.dynamicTest(
                            finalTitle,
                            () -> {
                                if (!verification.verify(row.getA(), row.getB(), row.getC(), row.getD(), row.getE())) {
                                    throw new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB() + ", " + headers.getC() + "=" + row.getC() + ", " + headers.getD() + "=" + row.getD() + ", " + headers.getE() + "=" + row.getE());

                                }
                            });
                });
            }
}
