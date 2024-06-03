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

public class Where1<A> {

    private final List<Row1<A>> data = new ArrayList<>();
    private final Headers1 headers;

    public Where1(Headers1 headers, Iterable<Row1<A>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    public Expectations expect(String template, Assertion1<A> verification) {
        return new Expectations1<>(this, template, verification);
    }

    public Expectations verify(String template, Verification1<A> verification) {
        return new Expectations1<>(this, template, a -> {
            verification.verify(a);
            return true;
        });
    }

    public Where1<A> and(A a) {
        data.add(new Row1<>(a));
        return this;
    }

    Stream<DynamicTest> generateTests(String template, Assertion1<A> verification) {
        return data.stream().map(row -> {
            String title = template.replace("#" + headers.getA(), String.valueOf(row.getA()));
            return DynamicTest.dynamicTest(
                    title,
                () -> {
                    if (!verification.verify(row.getA())) {
                        throw new AssertionFailedError("Verification failed for " + title + " with values " + headers.getA() + "=" + row.getA());
                    }
                }
            );
        });
    }
}
