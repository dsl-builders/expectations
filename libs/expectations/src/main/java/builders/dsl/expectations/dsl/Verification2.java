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
 * Represents an assertion that takes two parameters.
 *
 * @param <A> the type of the first parameter
 * @param <B> the type of the second parameter
 */
@FunctionalInterface
public interface Verification2<A, B> {

    /**
     * Verifies the given parameters and throws an exception if the verification fails.
     *
     * @param a the first parameter to verify
     * @param b the second parameter to verify
     */
    void verify(A a, B b) throws Throwable;

}
