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

public class Zip4<A, B, C, D> implements Iterable<Row4<A, B, C, D>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;

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
