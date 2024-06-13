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

/**
 * Represents a row with one element.
 *
 * @param <A> the type of the element
 */
public class Row1<A> {

    private final A a;

    /**
     * Creates a new row with one element.
     *
     * @param a the element
     */
    public Row1(A a) {
        this.a = a;
    }

    /**
     * Returns the element.
     *
     * @return the element
     */
    public A getA() {
        return a;
    }

}