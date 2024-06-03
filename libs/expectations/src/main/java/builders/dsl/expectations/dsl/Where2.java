package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Where2<A, B> {

    private final List<Row2<A, B>> data = new ArrayList<>();
    private final Headers2 headers;

    public Where2(Headers2 headers, Iterable<Row2<A, B>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    public Expectations expect(String template, Assertion2<A, B> verification) {
        return new Expectations2<>(this, template, verification);
    }

    public Expectations verify(String template, Verification2<A, B> verification) {
        return new Expectations2<>(this, template, (a, b) -> {
            verification.verify(a, b);
            return true;
        });
    }

    public Where2<A, B> and(A a, B b) {
        data.add(new Row2<>(a, b));
        return this;
    }

    Stream<DynamicTest> generateTests(String template, Assertion2<A, B> verification) {
        return data.stream().map(row -> {
            String title = template.replace("#" + headers.getA(), String.valueOf(row.getA()));
            String finalTitle = title.replace("#" + headers.getB(), String.valueOf(row.getB()));
            return DynamicTest.dynamicTest(
                    finalTitle,
                () -> {
                    if (!verification.verify(row.getA(), row.getB())) {
                        throw new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB());
                    }
                }
            );
        });
    }
}