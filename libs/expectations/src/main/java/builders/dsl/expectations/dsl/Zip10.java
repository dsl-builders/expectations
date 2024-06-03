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

public class Zip10<A, B, C, D, E, F, G, H, I, J> implements Iterable<Row10<A, B, C, D, E, F, G, H, I, J>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;
        private final Iterator<F> iteratorF;
        private final Iterator<G> iteratorG;
        private final Iterator<H> iteratorH;
        private final Iterator<I> iteratorI;
        private final Iterator<J> iteratorJ;

        public Zip10(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF, Iterator<G> valuesG, Iterator<H> valuesH, Iterator<I> valuesI, Iterator<J> valuesJ) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
            this.iteratorF = valuesF;
            this.iteratorG = valuesG;
            this.iteratorH = valuesH;
            this.iteratorI = valuesI;
            this.iteratorJ = valuesJ;
        }

        @Override
        public Iterator<Row10<A, B, C, D, E, F, G, H, I, J>> iterator() {
            return new Iterator<Row10<A, B, C, D, E, F, G, H, I, J>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext() && iteratorG.hasNext() && iteratorH.hasNext() && iteratorI.hasNext() && iteratorJ.hasNext();
                }

                @Override
                public Row10<A, B, C, D, E, F, G, H, I, J> next() {
                    return new Row10<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next(), iteratorG.next(), iteratorH.next(), iteratorI.next(), iteratorJ.next());
                }
            };
        }

}
