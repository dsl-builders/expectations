/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2024-2025 Vladimir Orany.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents the data table of the parametrized test with ten columns.
 *
 * @param <A> the type of the first column
 * @param <B> the type of the second column
 * @param <C> the type of the third column
 * @param <D> the type of the fourth column
 * @param <E> the type of the fifth column
 * @param <F> the type of the sixth column
 * @param <G> the type of the seventh column
 * @param <H> the type of the eighth column
 * @param <I> the type of the ninth column
 * @param <J> the type of the tenth column
 */
public class DataTable10<A, B, C, D, E, F, G, H, I, J> {

    private final List<Row10<A, B, C, D, E, F, G, H, I, J>> data = new ArrayList<>();
    private final Headers10 headers;

    /**
     * Creates a new data table with ten columns.
     *
     * @param headers the headers of the data table
     * @param rows    the rows of the data table
     */
    public DataTable10(Headers10 headers, Iterable<Row10<A, B, C, D, E, F, G, H, I, J>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    /**
     * Creates a new expectation for the data table.
     *
     * @param template     the template of the expectation where the placeholders are the headers of the data table prefixed with <code>#</code>
     * @param verification the assertion that must return <code>true</code> for the expectation to pass
     * @return the new expectation that can be used with {@link org.junit.jupiter.api.TestFactory} annotation to generate dynamic tests
     */
    public Expectations expect(String template, Assertion10<A, B, C, D, E, F, G, H, I, J> verification) {
        return new Expectations10<>(this, template, verification);
    }

    /**
     * Creates a new expectation for the data table.
     *
     * @param template     the template of the expectation where the placeholders are the headers of the data table prefixed with <code>#</code>
     * @param verification the assertion that must return <code>true</code> for the expectation to pass
     * @return the new expectation that can be used with {@link org.junit.jupiter.api.TestFactory} annotation to generate dynamic tests
     */
    public Expectations verify(String template, Verification10<A, B, C, D, E, F, G, H, I, J> verification) {
        return new Expectations10<>(this, template, (a, b, c, d, e, f, g, h, i, j) -> {
            verification.verify(a, b, c, d, e, f, g, h, i, j);
            return true;
        });
    }

    /**
     * Adds a new row to the data table.
     *
     * @param a the value of the first column
     * @param b the value of the second column
     * @param c the value of the third column
     * @param d the value of the fourth column
     * @param e the value of the fifth column
     * @param f the value of the sixth column
     * @param g the value of the seventh column
     * @param h the value of the eighth column
     * @param i the value of the ninth column
     * @param j the value of the tenth column
     * @return this data table
     */
    public DataTable10<A, B, C, D, E, F, G, H, I, J> and(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
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
                        boolean verified = false;
                        Throwable throwable = null;

                        try {
                            verified = verification.verify(row.getA(), row.getB(), row.getC(), row.getD(), row.getE(), row.getF(), row.getG(), row.getH(), row.getI(), row.getJ());
                        } catch (Throwable e) {
                            throwable = e;
                        }

                        if (!verified) {
                            throw new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB() + ", " + headers.getC() + "=" + row.getC() + ", " + headers.getD() + "=" + row.getD() + ", " + headers.getE() + "=" + row.getE() + ", " + headers.getF() + "=" + row.getF() + ", " + headers.getG() + "=" + row.getG() + ", " + headers.getH() + "=" + row.getH() + ", " + headers.getI() + "=" + row.getI() + ", " + headers.getJ() + "=" + row.getJ() + " " + row.getLocation(), throwable);
                        }
                    });
        });
    }

}
