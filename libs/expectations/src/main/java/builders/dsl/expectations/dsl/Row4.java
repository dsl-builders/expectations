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

/**
 * Represents a row with four elements.
 *
 * @param <A> the type of the first element
 * @param <B> the type of the second element
 * @param <C> the type of the third element
 * @param <D> the type of the fourth element
 */
public class Row4<A, B, C, D> {

    private final A a;
    private final B b;
    private final C c;
    private final D d;

    /**
     * Creates a new row with four elements.
     *
     * @param a the first element
     * @param b the second element
     * @param c the third element
     * @param d the fourth element
     */
    public Row4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * Returns the first element.
     *
     * @return the first element
     */
    public A getA() {
        return a;
    }

    /**
     * Returns the second element.
     *
     * @return the second element
     */
    public B getB() {
        return b;
    }

    /**
     * Returns the third element.
     *
     * @return the third element
     */
    public C getC() {
        return c;
    }

    /**
     * Returns the fourth element.
     *
     * @return the fourth element
     */
    public D getD() {
        return d;
    }

}
