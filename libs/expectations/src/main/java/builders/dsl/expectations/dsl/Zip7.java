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
 * This class combines seven iterables into an iterable of rows with seven columns.
 *
 * @param <A> the type of the first column
 * @param <B> the type of the second column
 * @param <C> the type of the third column
 * @param <D> the type of the fourth column
 * @param <E> the type of the fifth column
 * @param <F> the type of the sixth column
 * @param <G> the type of the seventh column
 */
public class Zip7<A, B, C, D, E, F, G> implements Iterable<Row7<A, B, C, D, E, F, G>> {

    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;
    private final Iterator<C> iteratorC;
    private final Iterator<D> iteratorD;
    private final Iterator<E> iteratorE;
    private final Iterator<F> iteratorF;
    private final Iterator<G> iteratorG;

    /**
     * Creates a new iterable of rows with seven columns.
     *
     * @param valuesA the values of the first column
     * @param valuesB the values of the second column
     * @param valuesC the values of the third column
     * @param valuesD the values of the fourth column
     * @param valuesE the values of the fifth column
     * @param valuesF the values of the sixth column
     * @param valuesG the values of the seventh column
     */
    public Zip7(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF, Iterator<G> valuesG) {
        this.iteratorA = valuesA;
        this.iteratorB = valuesB;
        this.iteratorC = valuesC;
        this.iteratorD = valuesD;
        this.iteratorE = valuesE;
        this.iteratorF = valuesF;
        this.iteratorG = valuesG;
    }

    @Override
    public Iterator<Row7<A, B, C, D, E, F, G>> iterator() {
        return new Iterator<Row7<A, B, C, D, E, F, G>>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext() && iteratorG.hasNext();
            }

            @Override
            public Row7<A, B, C, D, E, F, G> next() {
                return new Row7<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next(), iteratorG.next());
            }
        };
    }

}
