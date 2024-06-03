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

public class Zip8<A, B, C, D, E, F, G, H> implements Iterable<Row8<A, B, C, D, E, F, G, H>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;
        private final Iterator<F> iteratorF;
        private final Iterator<G> iteratorG;
        private final Iterator<H> iteratorH;

        public Zip8(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF, Iterator<G> valuesG, Iterator<H> valuesH) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
            this.iteratorF = valuesF;
            this.iteratorG = valuesG;
            this.iteratorH = valuesH;
        }

        @Override
        public Iterator<Row8<A, B, C, D, E, F, G, H>> iterator() {
            return new Iterator<Row8<A, B, C, D, E, F, G, H>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext() && iteratorG.hasNext() && iteratorH.hasNext();
                }

                @Override
                public Row8<A, B, C, D, E, F, G, H> next() {
                    return new Row8<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next(), iteratorG.next(), iteratorH.next());
                }
            };
        }

}
