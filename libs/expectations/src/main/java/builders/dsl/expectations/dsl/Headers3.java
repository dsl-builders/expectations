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

public class Headers3 {

    private final String a;
    private final String b;
    private final String c;

    public Headers3(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public <A, B, C> DataTable3<A, B, C> are(A a, B b, C c) {
        List<Row3<A, B, C>> rows = new ArrayList<>();
        rows.add(new Row3<>(a, b, c));
        return new DataTable3<>(this, rows);
    }

    /**
     * Creates the first data row with the three parameters.
     * <p>
     * Only rows with call to <code>only</code> method will be run.
     *
     * @param a the first value of the first parameter
     * @param b the first value of the second parameter
     * @param c the first value of the third parameter
     * @return the new data row with the three parameters
     */
    public <A, B, C> DataTable3<A, B, C> only(A a, B b, C c) {
        ContinuousIntegrationChecks.checkOnlyAllowed();
        List<Row3<A, B, C>> rows = new ArrayList<>();
        rows.add(new Row3<>(a, b, c));
        return new DataTable3<>(this, rows, true);
    }

}
