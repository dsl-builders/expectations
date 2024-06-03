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

public class Expectations1<A> implements Expectations {

    private final Where1<A> where;
    private final String template;
    private final Assertion1<A> verification;

    Expectations1(Where1<A> where, String template, Assertion1<A> verification) {
        this.where = where;
        this.template = template;
        this.verification = verification;
    }

    @Override
    public Iterator<DynamicContainer> iterator() {
        return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
    }

}