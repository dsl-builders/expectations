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

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the name of the single parameters.
 * <p>
 * This is the entrypoint to the DSL.
 */
public class Headers1 {

    private final String a;

    /**
     * Defines the name of the single parameters.
     *
     * @param a the name of the first parameter
     */
    public Headers1(String a) {
        this.a = a;
    }

    /**
     * Returns the name of the first parameter.
     *
     * @return the name of the first parameter
     */
    public String getA() {
        return a;
    }

    /**
     * Creates the first data row with the single parameter
     *
     * @param a the single value of the first parameter
     * @return the new data row with the single parameter
     */
    public <A> Where1<A> is(A a) {
        List<Row1<A>> rows = new ArrayList<>();
        rows.add(new Row1<>(a));
        return new Where1<>(this, rows);
    }

}