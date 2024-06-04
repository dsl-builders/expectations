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

public class Where3<A, B, C> {

    private final List<Row3<A, B, C>> data = new ArrayList<>();
    private final Headers3 headers;

    public Where3(Headers3 headers, Iterable<Row3<A, B, C>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    public Expectations expect(String template, Assertion3<A, B, C> verification) {
        return new Expectations3<>(this, template, verification);
    }

    public Expectations verify(String template, Verification3<A, B, C> verification) {
        return new Expectations3<>(this, template, (a, b, c) -> {
            verification.verify(a, b, c);
            return true;
        });
    }

    public Where3<A, B, C> and(A a, B b, C c) {
        data.add(new Row3<>(a, b, c));
        return this;
    }

    Stream<DynamicTest> generateTests(String template, Assertion3<A, B, C> verification) {
        return data.stream().map(row -> {
            String title = template.replace("#" + headers.getA(), String.valueOf(row.getA()));
            title = title.replace("#" + headers.getB(), String.valueOf(row.getB()));
            title = title.replace("#" + headers.getC(), String.valueOf(row.getC()));
            String finalTitle = title;
            return DynamicTest.dynamicTest(
                finalTitle,
                () -> {
                    if (!verification.verify(row.getA(), row.getB(), row.getC())) {
                        throw new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB() + ", " + headers.getC() + "=" + row.getC());
                    }
                }
            );
        });
    }
}

