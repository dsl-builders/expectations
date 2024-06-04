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
 * Represents an assertion that takes four parameters.
 *
 * @param <A> the type of the first parameter
 * @param <B> the type of the second parameter
 * @param <C> the type of the third parameter
 * @param <D> the type of the fourth parameter
 */
@FunctionalInterface
public interface Assertion4<A, B, C, D> {

    /**
     * Verifies the given parameters.
     *
     * @param a the first parameter to verify
     * @param b the second parameter to verify
     * @param c the third parameter to verify
     * @param d the fourth parameter to verify
     * @return {@code true} if the test for the given parameters passes, {@code false} otherwise
     */
    boolean verify(A a, B b, C c, D d);

}
