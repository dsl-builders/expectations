/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2024 Vladimir Orany.
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
 * Represents the data table of the parametrized test with five columns.
 *
 * @param <A> the type of the first column
 * @param <B> the type of the second column
 * @param <C> the type of the third column
 * @param <D> the type of the fourth column
 * @param <E> the type of the fifth column
 */
public class DataTable5<A, B, C, D, E> {

    private final List<Row5<A, B, C, D, E>> data = new ArrayList<>();
    private final Headers5 headers;

    /**
     * Creates a new data table with five columns.
     *
     * @param headers the headers of the data table
     * @param rows    the rows of the data table
     */
    public DataTable5(Headers5 headers, Iterable<Row5<A, B, C, D, E>> rows) {
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
    public Expectations expect(String template, Assertion5<A, B, C, D, E> verification) {
        return new Expectations5<>(this, template, verification);
    }

    /**
     * Creates a new expectation for the data table.
     *
     * @param template     the template of the expectation where the placeholders are the headers of the data table prefixed with <code>#</code>
     * @param verification the assertion that must return <code>true</code> for the expectation to pass
     * @return the new expectation that can be used with {@link org.junit.jupiter.api.TestFactory} annotation to generate dynamic tests
     */
    public Expectations verify(String template, Verification5<A, B, C, D, E> verification) {
        return new Expectations5<>(this, template, (a, b, c, d, e) -> {
            verification.verify(a, b, c, d, e);
            return true;
        });
    }

    /**
     * Adds a new row to the data table.
     *
     * @param a the first element
     * @param b the second element
     * @param c the third element
     * @param d the fourth element
     * @param e the fifth element
     * @return self with the new row added
     */
    public DataTable5<A, B, C, D, E> and(A a, B b, C c, D d, E e) {
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
