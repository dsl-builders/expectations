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

import java.util.Iterator;

public class Zip5<A, B, C, D, E> implements Iterable<Row5<A, B, C, D, E>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;

        public Zip5(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
        }

        @Override
        public Iterator<Row5<A, B, C, D, E>> iterator() {
            return new Iterator<Row5<A, B, C, D, E>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext();
                }

                @Override
                public Row5<A, B, C, D, E> next() {
                    return new Row5<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next());
                }
            };
        }

}
