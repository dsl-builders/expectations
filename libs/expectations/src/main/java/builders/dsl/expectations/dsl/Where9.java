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

public class Where9<A, B, C, D, E, F, G, H, I> {

    private final List<Row9<A, B, C, D, E, F, G, H, I>> data = new ArrayList<>();
    private final Headers9 headers;

    public Where9(Headers9 headers, Iterable<Row9<A, B, C, D, E, F, G, H, I>> rows) {
        this.headers = headers;
        rows.forEach(data::add);
    }

    public Expectations expect(String template, Assertion9<A, B, C, D, E, F, G, H, I> verification) {
        return new Expectations9<>(this, template, verification);
    }

    public Expectations verify(String template, Verification9<A, B, C, D, E, F, G, H, I> verification) {
        return new Expectations9<>(this, template, (a, b, c, d, e, f, g, h, i) -> {
            verification.verify(a, b, c, d, e, f, g, h, i);
            return true;
        });
    }

    public Where9<A, B, C, D, E, F, G, H, I> and(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        data.add(new Row9<>(a, b, c, d, e, f, g, h, i));
        return this;
    }

    Stream<DynamicTest> generateTests(String template, Assertion9<A, B, C, D, E, F, G, H, I> verification) {
        return data.stream().map(row -> {
            String title = template.replace("#" + headers.getA(), String.valueOf(row.getA()));
            title = title.replace("#" + headers.getB(), String.valueOf(row.getB()));
            title = title.replace("#" + headers.getC(), String.valueOf(row.getC()));
            title = title.replace("#" + headers.getD(), String.valueOf(row.getD()));
            title = title.replace("#" + headers.getE(), String.valueOf(row.getE()));
            title = title.replace("#" + headers.getF(), String.valueOf(row.getF()));
            title = title.replace("#" + headers.getG(), String.valueOf(row.getG()));
            title = title.replace("#" + headers.getH(), String.valueOf(row.getH()));
            String finalTitle = title.replace("#" + headers.getI(), String.valueOf(row.getI()));
            return DynamicTest.dynamicTest(
                    finalTitle,
                    () -> {
                        if (!verification.verify(row.getA(), row.getB(), row.getC(), row.getD(), row.getE(), row.getF(), row.getG(), row.getH(), row.getI())) {
                            throw new AssertionFailedError("Verification failed for " + finalTitle + " with values " + headers.getA() + "=" + row.getA() + ", " + headers.getB() + "=" + row.getB() + ", " + headers.getC() + "=" + row.getC() + ", " + headers.getD() + "=" + row.getD() + ", " + headers.getE() + "=" + row.getE() + ", " + headers.getF() + "=" + row.getF() + ", " + headers.getG() + "=" + row.getG() + ", " + headers.getH() + "=" + row.getH() + ", " + headers.getI() + "=" + row.getI());
                        }
                    });
        });
    }


}
