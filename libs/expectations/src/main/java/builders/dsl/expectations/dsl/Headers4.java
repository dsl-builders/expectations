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

public class Headers4 {

    private final String a;
    private final String b;
    private final String c;
    private final String d;

    public Headers4(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public <A, B, C, D> DataTable4<A, B, C, D> are(A a, B b, C c, D d) {
        List<Row4<A, B, C, D>> rows = new ArrayList<>();
        rows.add(new Row4<>(a, b, c, d));
        return new DataTable4<>(this, rows);
    }

    /**
     * Creates the first data row with the four parameters.
     * <p>
     * Only rows with call to <code>only</code> method will be run.
     *
     * @param a the first value of the first parameter
     * @param b the first value of the second parameter
     * @param c the first value of the third parameter
     * @param d the first value of the fourth parameter
     * @return the new data row with the four parameters
     */
    public <A, B, C, D> DataTable4<A, B, C, D> only(A a, B b, C c, D d) {
        ContinuousIntegrationChecks.checkOnlyAllowed();
        List<Row4<A, B, C, D>> rows = new ArrayList<>();
        rows.add(new Row4<>(a, b, c, d));
        return new DataTable4<>(this, rows, true);
    }

}