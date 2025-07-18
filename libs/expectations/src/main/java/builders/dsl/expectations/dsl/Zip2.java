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

import java.util.Iterator;

/**
 * This class combines two iterables into an iterable of rows with two columns.
 *
 * @param <A> the type of the first column
 * @param <B> the type of the second column
 */
public class Zip2<A, B> implements Iterable<Row2<A, B>> {

    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;

    /**
     * Creates a new iterable of rows with two columns.
     *
     * @param valuesA the values of the first column
     * @param valuesB the values of the second column
     */
    public Zip2(Iterator<A> valuesA, Iterator<B> valuesB) {
        this.iteratorA = valuesA;
        this.iteratorB = valuesB;
    }

    @Override
    public Iterator<Row2<A, B>> iterator() {
        return new Iterator<Row2<A, B>>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext();
            }

            @Override
            public Row2<A, B> next() {
                return new Row2<>(iteratorA.next(), iteratorB.next());
            }
        };
    }

}
