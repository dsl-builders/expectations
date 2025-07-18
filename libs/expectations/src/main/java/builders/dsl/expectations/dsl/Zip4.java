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
 * This class combines four iterables into an iterable of rows with four columns.
 *
 * @param <A> the type of the first column
 * @param <B> the type of the second column
 * @param <C> the type of the third column
 * @param <D> the type of the fourth column
 */
public class Zip4<A, B, C, D> implements Iterable<Row4<A, B, C, D>> {

    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;
    private final Iterator<C> iteratorC;
    private final Iterator<D> iteratorD;

    /**
     * Creates a new iterable of rows with four columns.
     *
     * @param valuesA the values of the first column
     * @param valuesB the values of the second column
     * @param valuesC the values of the third column
     * @param valuesD the values of the fourth column
     */
    public Zip4(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD) {
        this.iteratorA = valuesA;
        this.iteratorB = valuesB;
        this.iteratorC = valuesC;
        this.iteratorD = valuesD;
    }

    @Override
    public Iterator<Row4<A, B, C, D>> iterator() {
        return new Iterator<Row4<A, B, C, D>>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext();
            }

            @Override
            public Row4<A, B, C, D> next() {
                return new Row4<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next());
            }
        };
    }

}
