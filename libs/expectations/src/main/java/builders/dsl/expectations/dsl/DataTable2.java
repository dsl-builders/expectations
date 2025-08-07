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
import builders.dsl.expectations.source.SourceLocationInfo;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents the data table of the parametrized test with two columns.
 * @param <A> the type of the first column
 * @param <B> the type of the second column
 */
public class DataTable2<A, B> {

    private final List<Row2<A, B>> data = new ArrayList<>();
    private final Headers2 headers;

    /**
     * Creates a new data table with two columns.
     * @param headers the headers of the data table
     * @param rows the rows of the data table
     */
    public DataTable2(Headers2 headers, Iterable<Row2<A, B>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    /**
     * Creates a new expectation for the data table.
     * @param template the template of the expectation where the placeholders are the headers of the data table prefixed with <code>#</code>
     * @param verification the assertion that must return <code>true</code> for the expectation to pass
     * @return the new expectation that can be used with {@link org.junit.jupiter.api.TestFactory} annotation to generate dynamic tests
     */
    public Expectations expect(String template, Assertion2<A, B> verification) {
        return new Expectations2<>(this, template, verification);
    }

    /**
     * Creates a new expectation for the data table.
     * @param template the template of the expectation where the placeholders are the headers of the data table prefixed with <code>#</code>
     * @param verification the verification that uses any testing library to assert that the expectation is met
     * @return the new expectation that can be used with {@link org.junit.jupiter.api.TestFactory} annotation to generate dynamic tests
     */
    public Expectations verify(String template, Verification2<A, B> verification) {
        return new Expectations2<>(this, template, (a, b) -> {
            verification.verify(a, b);
            return true;
        });
    }

    /**
     * Adds a new row to the data table.
     * @param a the value of the first column
     * @param b the value of the second column
     * @return self with the new row added
     */
    public DataTable2<A, B> and(A a, B b) {
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
                    boolean verified;

                    try {
                        verified = verification.verify(row.getA(), row.getB());
                    } catch (Throwable e) {
                        e.addSuppressed(new SourceLocationInfo(row.getLocation()));
                        throw e;
                    }

                    if (!verified) {
                        AssertionFailedError assertionFailedError = new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB());
                        assertionFailedError.addSuppressed(new SourceLocationInfo(row.getLocation()));
                        throw assertionFailedError;
                    }
                }
            );
        });
    }
}
