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

/**
 * This class wraps an iterable into iterable of rows with a single column.
 */
public class Zip1<A> implements Iterable<Row1<A>> {

    private final Iterator<A> iteratorA;

    public Zip1(Iterator<A> valuesA) {
        this.iteratorA = valuesA;
    }

    @Override
    public Iterator<Row1<A>> iterator() {
        return new Iterator<Row1<A>>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext();
            }

            @Override
            public Row1<A> next() {
                return new Row1<>(iteratorA.next());
            }
        };
    }

}
