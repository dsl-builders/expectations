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

import builders.dsl.expectations.ci.ContinuousIntegrationChecks;

import java.util.ArrayList;
import java.util.List;

public class Headers9 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    public Headers9(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getE() {
        return e;
    }

    public String getF() {
        return f;
    }

    public String getG() {
        return g;
    }

    public String getH() {
        return h;
    }

    public String getI() {
        return i;
    }

    public <A, B, C, D, E, F, G, H, I> DataTable9<A, B, C, D, E, F, G, H, I> are(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        List<Row9<A, B, C, D, E, F, G, H, I>> rows = new ArrayList<>();
        rows.add(new Row9<>(a, b, c, d, e, f, g, h, i));
        return new DataTable9<>(this, rows);
    }

    /**
     * Creates the first data row with the nine parameters.
     * <p>
     * Only rows with call to <code>only</code> method will be run.
     *
     * @param a the first value of the first parameter
     * @param b the first value of the second parameter
     * @param c the first value of the third parameter
     * @param d the first value of the fourth parameter
     * @param e the first value of the fifth parameter
     * @param f the first value of the sixth parameter
     * @param g the first value of the seventh parameter
     * @param h the first value of the eighth parameter
     * @param i the first value of the ninth parameter
     * @return the new data row with the nine parameters
     */
    public <A, B, C, D, E, F, G, H, I> DataTable9<A, B, C, D, E, F, G, H, I> only(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        ContinuousIntegrationChecks.checkOnlyAllowed();
        List<Row9<A, B, C, D, E, F, G, H, I>> rows = new ArrayList<>();
        rows.add(new Row9<>(a, b, c, d, e, f, g, h, i));
        return new DataTable9<>(this, rows, true);
    }

}