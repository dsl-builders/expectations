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

import builders.dsl.expectations.source.SourceLocation;

/**
 * Represents a row with seven elements.
 *
 * @param <A> the type of the first element
 * @param <B> the type of the second element
 * @param <C> the type of the third element
 * @param <D> the type of the fourth element
 * @param <E> the type of the fifth element
 * @param <F> the type of the sixth element
 * @param <G> the type of the seventh element
 */
public class Row7<A, B, C, D, E, F, G> {

    private final A a;
    private final B b;
    private final C c;
    private final D d;
    private final E e;
    private final F f;
    private final G g;
    private final SourceLocation location;

    /**
     * Creates a new row with seven elements.
     *
     * @param a the first element
     * @param b the second element
     * @param c the third element
     * @param d the fourth element
     * @param e the fifth element
     * @param f the sixth element
     * @param g the seventh element
     */
    public Row7(A a, B b, C c, D d, E e, F f, G g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.location = SourceLocation.createLocationInTheTestClass();
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

    /**
     * Returns the fifth element.
     *
     * @return the fifth element
     */
    public E getE() {
        return e;
    }

    /**
     * Returns the sixth element.
     *
     * @return the sixth element
     */
    public F getF() {
        return f;
    }

    /**
     * Returns the seventh element.
     *
     * @return the seventh element
     */
    public G getG() {
        return g;
    }

    /**
     * Returns the source location where the row was created.
     *
     * @return the source location
     */
    public SourceLocation getLocation() {
        return location;
    }

}
