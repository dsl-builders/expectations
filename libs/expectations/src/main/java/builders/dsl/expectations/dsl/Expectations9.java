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

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

/**
 * This class represents the parameterized dynamic test with nine parameters.
 * @param <A> the type of the first parameter
 * @param <B> the type of the second parameter
 * @param <C> the type of the third parameter
 * @param <D> the type of the fourth parameter
 * @param <E> the type of the fifth parameter
 * @param <F> the type of the sixth parameter
 * @param <G> the type of the seventh parameter
 * @param <H> the type of the eighth parameter
 * @param <I> the type of the ninth parameter
 */
public class Expectations9<A, B, C, D, E, F, G, H, I> implements Expectations {

        private final DataTable9<A, B, C, D, E, F, G, H, I> where;
        private final String template;
        private final Assertion9<A, B, C, D, E, F, G, H, I> verification;

        Expectations9(DataTable9<A, B, C, D, E, F, G, H, I> where, String template, Assertion9<A, B, C, D, E, F, G, H, I> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}