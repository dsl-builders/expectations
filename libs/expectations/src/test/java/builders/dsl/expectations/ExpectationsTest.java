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
package builders.dsl.expectations;

import builders.dsl.expectations.ci.ContinuousIntegrationChecks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.opentest4j.MultipleFailuresError;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static builders.dsl.expectations.Expectations.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpectationsTest {

    @BeforeEach
    void setUp() {
        ContinuousIntegrationChecks.setOnlyAllowed(true);
    }

    @AfterEach
    void tearDown() {
        ContinuousIntegrationChecks.setOnlyAllowed(ContinuousIntegrationChecks.isRunningCI());
    }

    @TestFactory
    Expectations basicTest1Fluent() {
        Calculator calculator = new Calculator();

        return given("a")
                .is(2)
                .and(3)
                .expect("#a + 0 = #a", a -> calculator.add(a, 0) == a);
    }

    @Test
    void basicTest1FluentManual() {
        Calculator calculator = new Calculator();

        given("a")
                .is(2)
                .and(3)
                .expect("#a + 0 = #a", a -> calculator.add(a, 0) == a)
                .evaluate();
    }

    @Test
    void basicTest1FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a")
                    .is(4)
                    .and(3)
                    .expect("#a + 1 = #a", a -> calculator.add(a, 1) == a)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest1FluentFailure() {
        Calculator calculator = new Calculator();

        return given("a")
                .is(2)
                .and(3)
                .expect("#a + 0 = #a", a -> calculator.add(a, 0) == a);
    }

    @TestFactory
    Expectations basicTest1FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a")
                .is(2)
                .and(3)
                .verify("#a + 0 = #a", a ->
                        assertEquals((int) a, calculator.add(a, 0))
                );
    }

    @TestFactory
    Expectations basicTest1WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3)
        ).expect("#a + 0 = #a", a ->
                calculator.add(a, 0) == a
        );
    }

    @TestFactory
    Expectations basicTest1WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3)
        ).expect("#a + 0 = #a", a ->
                calculator.add(a, 0) == a
        );
    }

    @TestFactory
    Expectations basicTest1WithOnly() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 3));

        return Expectations.given("number")
                .only(1)
                .and(2)
                .only(3)
                .and(4)
                .and(5)
                .expect("#number is in the set", set::contains);
    }

    @TestFactory
    Expectations basicTest1HeadersWithOnly() {
        Set<Integer> set = new HashSet<>(Arrays.asList(7, 9));

        return Expectations.given("number")
                .only(7)
                .only(9)
                .and(999)  // This should be skipped - would fail if executed (999 not in set)
                .expect("#number is in the set", set::contains);
    }

    @TestFactory
    Expectations basicTest2Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b")
                .are(2, 3)
                .and(3, 2)
                .expect("#a + #b = 5", (a, b) -> calculator.add(a, b) == 5);
    }

    @Test
    void basicTest2FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b")
                    .are(2, 3)
                    .and(3, 2)
                    .expect("#a + #b = 6", (a, b) -> calculator.add(a, b) == 6)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest2FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b")
                .are(2, 3)
                .and(3, 2)
                .verify("#a + #b = 5", (a, b) ->
                        assertEquals(5, calculator.add(a, b))
                );
    }

    @TestFactory
    Expectations basicTest2WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b")
                .are(1, 4)
                .and(2, 2)
                .only(2, 3)
                .and(999, 999)  // This should be skipped - would fail if executed (999 + 999 != 5)
                .only(4, 1)
                .and(888, 888)  // This should be skipped - would fail if executed (888 + 888 != 5)
                .expect("#a + #b = 5", (a, b) -> calculator.add(a, b) == 5);
    }

    @TestFactory
    Expectations basicTest2HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b")
                .only(1, 4)
                .only(3, 2)
                .and(500, 500)  // This should be skipped - would fail if executed (500 + 500 != 5)
                .expect("#a + #b = 5", (a, b) -> calculator.add(a, b) == 5);
    }

    @TestFactory
    Expectations basicTest2WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3),
                "b", Stream.of(3, 2)
        ).expect("#a + #b = 5", (a, b) ->
                calculator.add(a, b) == 5
        );
    }

    @TestFactory
    Expectations basicTest2WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3),
                "b", Arrays.asList(3, 2)
        ).expect("#a + #b = 5", (a, b) ->
                calculator.add(a, b) == 5
        );
    }

    // tag::fluent-expect[]
    @TestFactory                                                                        // <1>
    Expectations basicTest3Fluent() {                                                   // <2>
        Calculator calculator = new Calculator();

        return given("a", "b", "c")                                                     // <3>
                .are(2, 3, 5)                                                           // <4>
                .and(3, 5, 8)
                .and(4, 7, 11)
                .expect(
                        "#a + #b = #c",                                                 // <5>
                        (a, b, c) -> calculator.add(a, b) == c                          // <6>
                );
    }
    // end::fluent-expect[]


    // tag::immediately-verify[]
    @Test                                                                               // <1>
    void basicTest3FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c")
                    .are(2, 3, 6)
                    .and(3, 5, 9)
                    .and(4, 7, 11)
                    .expect("#a + #b = #c", (a, b, c) -> calculator.add(a, b) == c)
                    .evaluate();                                                          // <2>
        });
    }
    // end::immediately-verify[]

    // tag::junit-assertions[]
    @TestFactory
    Expectations basicTest3FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c")
                .are(2, 3, 5)
                .and(3, 5, 8)
                .and(4, 7, 11)
                .verify("#a + #b = #c", (a, b, c) ->
                        assertEquals((int) c, calculator.add(a, b))                     // <1>
                );
    }
    // end::junit-assertions[]

    @TestFactory
    Expectations basicTest3WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c")
                .are(1, 1, 1)
                .and(2, 2, 3)
                .only(2, 3, 5)
                .and(777, 777, 777)  // This should be skipped - would fail if executed (777 + 777 != 777)
                .only(3, 5, 8)
                .and(666, 666, 666)  // This should be skipped - would fail if executed (666 + 666 != 666)
                .expect("#a + #b = #c", (a, b, c) -> calculator.add(a, b) == c);
    }

    @TestFactory
    Expectations basicTest3HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c")
                .only(2, 3, 5)
                .only(3, 5, 8)
                .and(888, 777, 666)  // This should be skipped - would fail if executed (888 + 777 != 666)
                .expect("#a + #b = #c", (a, b, c) -> calculator.add(a, b) == c);
    }


    // tag::streams[]
    @TestFactory
    Expectations basicTest3WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),                                                // <1>
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11)
        ).expect("#a + #b = #c", (a, b, c) ->
                calculator.add(a, b) == c
        );
    }
    // end::streams[]

    @TestFactory
    Expectations basicTest3WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11)
        ).expect("#a + #b = #c", (a, b, c) ->
                calculator.add(a, b) == c
        );
    }

    @TestFactory
    Expectations basicTest4Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d")
                .are(2, 3, 5, 10)
                .and(3, 5, 8, 16)
                .and(4, 7, 11, 22)
                .expect("#a + #b + #c = #d", (a, b, c, d) -> calculator.add(a, b, c) == d);
    }

    @Test
    void basicTest4FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d")
                    .are(2, 3, 5, 11)
                    .and(3, 5, 8, 17)
                    .and(4, 7, 11, 23)
                    .expect("#a + #b + #c = #d", (a, b, c, d) -> calculator.add(a, b, c) == d)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest4FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d")
                .are(2, 3, 5, 10)
                .and(3, 5, 8, 16)
                .and(4, 7, 11, 22)
                .verify("#a + #b + #c = #d", (a, b, c, d) ->
                        assertEquals((int) d, calculator.add(a, b, c))
                );
    }

    @TestFactory
    Expectations basicTest4WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d")
                .are(1, 1, 1, 2)
                .and(2, 2, 2, 5)
                .only(2, 3, 5, 10)
                .and(999, 999, 999, 999)  // This should be skipped - would fail if executed (999 + 999 + 999 != 999)
                .only(3, 5, 8, 16)
                .and(888, 888, 888, 888)  // This should be skipped - would fail if executed (888 + 888 + 888 != 888)
                .expect("#a + #b + #c = #d", (a, b, c, d) -> calculator.add(a, b, c) == d);
    }

    @TestFactory
    Expectations basicTest4HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d")
                .only(2, 3, 5, 10)
                .only(3, 5, 8, 16)
                .and(777, 666, 555, 444)  // This should be skipped - would fail if executed (777 + 666 + 555 != 444)
                .expect("#a + #b + #c = #d", (a, b, c, d) -> calculator.add(a, b, c) == d);
    }

    @TestFactory
    Expectations basicTest4WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11),
                "d", Stream.of(10, 16, 22)
        ).expect("#a + #b + #c = #d", (a, b, c, d) ->
                calculator.add(a, b, c) == d
        );
    }

    @TestFactory
    Expectations basicTest4WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11),
                "d", Arrays.asList(10, 16, 22)
        ).expect("#a + #b + #c = #d", (a, b, c, d) ->
                calculator.add(a, b, c) == d
        );
    }

    @TestFactory
    Expectations basicTest5Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e")
                .are(2, 3, 5, 10, 20)
                .and(3, 5, 8, 16, 32)
                .and(4, 7, 11, 22, 44)
                .expect("#a + #b + #c + #d = #e", (a, b, c, d, e) -> calculator.add(a, b, c, d) == e);
    }

    @Test
    void basicTest5FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d", "e")
                    .are(2, 3, 5, 10, 21)
                    .and(3, 5, 8, 16, 33)
                    .and(4, 7, 11, 22, 45)
                    .expect("#a + #b + #c + #d = #e", (a, b, c, d, e) -> calculator.add(a, b, c, d) == e)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest5FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e")
                .are(2, 3, 5, 10, 20)
                .and(3, 5, 8, 16, 32)
                .and(4, 7, 11, 22, 44)
                .verify("#a + #b + #c + #d = #e", (a, b, c, d, e) ->
                        assertEquals((int) e, calculator.add(a, b, c, d))
                );
    }

    @TestFactory
    Expectations basicTest5WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e")
                .are(1, 1, 1, 1, 3)
                .and(2, 2, 2, 2, 7)
                .only(2, 3, 5, 10, 20)
                .and(999, 888, 777, 666, 555)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 != 555)
                .only(3, 5, 8, 16, 32)
                .and(444, 333, 222, 111, 100)  // This should be skipped - would fail if executed (444 + 333 + 222 + 111 != 100)
                .expect("#a + #b + #c + #d = #e", (a, b, c, d, e) -> calculator.add(a, b, c, d) == e);
    }

    @TestFactory
    Expectations basicTest5HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e")
                .only(2, 3, 5, 10, 20)
                .only(3, 5, 8, 16, 32)
                .and(999, 888, 777, 666, 555)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 != 555)
                .expect("#a + #b + #c + #d = #e", (a, b, c, d, e) -> calculator.add(a, b, c, d) == e);
    }

    @TestFactory
    Expectations basicTest5WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11),
                "d", Stream.of(10, 16, 22),
                "e", Stream.of(20, 32, 44)
        ).expect("#a + #b + #c + #d = #e", (a, b, c, d, e) ->
                calculator.add(a, b, c, d) == e
        );
    }

    @TestFactory
    Expectations basicTest5WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11),
                "d", Arrays.asList(10, 16, 22),
                "e", Arrays.asList(20, 32, 44)
        ).expect("#a + #b + #c + #d = #e", (a, b, c, d, e) ->
                calculator.add(a, b, c, d) == e
        );
    }

    @TestFactory
    Expectations basicTest6Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f")
                .are(2, 3, 5, 10, 20, 40)
                .and(3, 5, 8, 16, 32, 64)
                .and(4, 7, 11, 22, 44, 88)
                .expect("#a + #b + #c + #d + #e = #f", (a, b, c, d, e, f) -> calculator.add(a, b, c, d, e) == f);
    }

    @Test
    void basicTest6FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d", "e", "f")
                    .are(2, 3, 5, 10, 20, 41)
                    .and(3, 5, 8, 16, 32, 65)
                    .and(4, 7, 11, 22, 44, 89)
                    .expect("#a + #b + #c + #d + #e = #f", (a, b, c, d, e, f) -> calculator.add(a, b, c, d, e) == f)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest6FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f")
                .are(2, 3, 5, 10, 20, 40)
                .and(3, 5, 8, 16, 32, 64)
                .and(4, 7, 11, 22, 44, 88)
                .verify("#a + #b + #c + #d + #e = #f", (a, b, c, d, e, f) ->
                        assertEquals((int) f, calculator.add(a, b, c, d, e))
                );
    }

    @TestFactory
    Expectations basicTest6WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f")
                .are(1, 1, 1, 1, 1, 4)
                .and(2, 2, 2, 2, 2, 9)
                .only(2, 3, 5, 10, 20, 40)
                .and(999, 888, 777, 666, 555, 444)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 != 444)
                .only(3, 5, 8, 16, 32, 64)
                .and(333, 222, 111, 100, 200, 300)  // This should be skipped - would fail if executed (333 + 222 + 111 + 100 + 200 != 300)
                .expect("#a + #b + #c + #d + #e = #f", (a, b, c, d, e, f) -> calculator.add(a, b, c, d, e) == f);
    }

    @TestFactory
    Expectations basicTest6HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f")
                .only(2, 3, 5, 10, 20, 40)
                .only(3, 5, 8, 16, 32, 64)
                .and(999, 888, 777, 666, 555, 444)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 != 444)
                .expect("#a + #b + #c + #d + #e = #f", (a, b, c, d, e, f) -> calculator.add(a, b, c, d, e) == f);
    }

    @TestFactory
    Expectations basicTest6WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11),
                "d", Stream.of(10, 16, 22),
                "e", Stream.of(20, 32, 44),
                "f", Stream.of(40, 64, 88)
        ).expect("#a + #b + #c + #d + #e = #f", (a, b, c, d, e, f) ->
                calculator.add(a, b, c, d, e) == f
        );
    }

    @TestFactory
    Expectations basicTest6WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11),
                "d", Arrays.asList(10, 16, 22),
                "e", Arrays.asList(20, 32, 44),
                "f", Arrays.asList(40, 64, 88)
        ).expect("#a + #b + #c + #d + #e = #f", (a, b, c, d, e, f) ->
                calculator.add(a, b, c, d, e) == f
        );
    }

    @TestFactory
    Expectations basicTest7Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g")
                .are(2, 3, 5, 10, 20, 40, 80)
                .and(3, 5, 8, 16, 32, 64, 128)
                .and(4, 7, 11, 22, 44, 88, 176)
                .expect("#a + #b + #c + #d + #e + #f = #g", (a, b, c, d, e, f, g) -> calculator.add(a, b, c, d, e, f) == g);
    }

    @Test
    void basicTest7FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d", "e", "f", "g")
                    .are(2, 3, 5, 10, 20, 40, 81)
                    .and(3, 5, 8, 16, 32, 64, 129)
                    .and(4, 7, 11, 22, 44, 88, 177)
                    .expect("#a + #b + #c + #d + #e + #f = #g", (a, b, c, d, e, f, g) -> calculator.add(a, b, c, d, e, f) == g)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest7FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g")
                .are(2, 3, 5, 10, 20, 40, 80)
                .and(3, 5, 8, 16, 32, 64, 128)
                .and(4, 7, 11, 22, 44, 88, 176)
                .verify("#a + #b + #c + #d + #e + #f = #g", (a, b, c, d, e, f, g) ->
                        assertEquals((int) g, calculator.add(a, b, c, d, e, f))
                );
    }

    @TestFactory
    Expectations basicTest7WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g")
                .are(1, 1, 1, 1, 1, 1, 5)
                .and(2, 2, 2, 2, 2, 2, 11)
                .only(2, 3, 5, 10, 20, 40, 80)
                .and(999, 888, 777, 666, 555, 444, 333)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 != 333)
                .only(3, 5, 8, 16, 32, 64, 128)
                .and(222, 111, 100, 200, 300, 400, 500)  // This should be skipped - would fail if executed (222 + 111 + 100 + 200 + 300 + 400 != 500)
                .expect("#a + #b + #c + #d + #e + #f = #g", (a, b, c, d, e, f, g) -> calculator.add(a, b, c, d, e, f) == g);
    }

    @TestFactory
    Expectations basicTest7HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g")
                .only(2, 3, 5, 10, 20, 40, 80)
                .only(3, 5, 8, 16, 32, 64, 128)
                .and(999, 888, 777, 666, 555, 444, 333)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 != 333)
                .expect("#a + #b + #c + #d + #e + #f = #g", (a, b, c, d, e, f, g) -> calculator.add(a, b, c, d, e, f) == g);
    }

    @TestFactory
    Expectations basicTest7WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11),
                "d", Stream.of(10, 16, 22),
                "e", Stream.of(20, 32, 44),
                "f", Stream.of(40, 64, 88),
                "g", Stream.of(80, 128, 176)
        ).expect("#a + #b + #c + #d + #e + #f = #g", (a, b, c, d, e, f, g) ->
                calculator.add(a, b, c, d, e, f) == g
        );
    }

    @TestFactory
    Expectations basicTest7WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11),
                "d", Arrays.asList(10, 16, 22),
                "e", Arrays.asList(20, 32, 44),
                "f", Arrays.asList(40, 64, 88),
                "g", Arrays.asList(80, 128, 176)
        ).expect("#a + #b + #c + #d + #e + #f = #g", (a, b, c, d, e, f, g) ->
                calculator.add(a, b, c, d, e, f) == g
        );
    }

    @TestFactory
    Expectations basicTest8Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h")
                .are(2, 3, 5, 10, 20, 40, 80, 160)
                .and(3, 5, 8, 16, 32, 64, 128, 256)
                .and(4, 7, 11, 22, 44, 88, 176, 352)
                .expect("#a + #b + #c + #d + #e + #f + #g = #h", (a, b, c, d, e, f, g, h) -> calculator.add(a, b, c, d, e, f, g) == h);
    }

    @Test
    void basicTest8FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d", "e", "f", "g", "h")
                    .are(2, 3, 5, 10, 20, 40, 80, 161)
                    .and(3, 5, 8, 16, 32, 64, 128, 257)
                    .and(4, 7, 11, 22, 44, 88, 176, 353)
                    .expect("#a + #b + #c + #d + #e + #f + #g = #h", (a, b, c, d, e, f, g, h) -> calculator.add(a, b, c, d, e, f, g) == h)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest8FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h")
                .are(2, 3, 5, 10, 20, 40, 80, 160)
                .and(3, 5, 8, 16, 32, 64, 128, 256)
                .and(4, 7, 11, 22, 44, 88, 176, 352)
                .verify("#a + #b + #c + #d + #e + #f + #g = #h", (a, b, c, d, e, f, g, h) ->
                        assertEquals((int) h, calculator.add(a, b, c, d, e, f, g))
                );
    }

    @TestFactory
    Expectations basicTest8WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h")
                .are(1, 1, 1, 1, 1, 1, 1, 6)
                .and(2, 2, 2, 2, 2, 2, 2, 13)
                .only(2, 3, 5, 10, 20, 40, 80, 160)
                .and(999, 888, 777, 666, 555, 444, 333, 222)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 + 333 != 222)
                .only(3, 5, 8, 16, 32, 64, 128, 256)
                .and(111, 100, 200, 300, 400, 500, 600, 700)  // This should be skipped - would fail if executed (111 + 100 + 200 + 300 + 400 + 500 + 600 != 700)
                .expect("#a + #b + #c + #d + #e + #f + #g = #h", (a, b, c, d, e, f, g, h) -> calculator.add(a, b, c, d, e, f, g) == h);
    }

    @TestFactory
    Expectations basicTest8HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h")
                .only(2, 3, 5, 10, 20, 40, 80, 160)
                .only(3, 5, 8, 16, 32, 64, 128, 256)
                .and(999, 888, 777, 666, 555, 444, 333, 222)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 + 333 != 222)
                .expect("#a + #b + #c + #d + #e + #f + #g = #h", (a, b, c, d, e, f, g, h) -> calculator.add(a, b, c, d, e, f, g) == h);
    }

    @TestFactory
    Expectations basicTest8WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11),
                "d", Stream.of(10, 16, 22),
                "e", Stream.of(20, 32, 44),
                "f", Stream.of(40, 64, 88),
                "g", Stream.of(80, 128, 176),
                "h", Stream.of(160, 256, 352)
        ).expect("#a + #b + #c + #d + #e + #f + #g = #h", (a, b, c, d, e, f, g, h) ->
                calculator.add(a, b, c, d, e, f, g) == h
        );
    }

    @TestFactory
    Expectations basicTest8WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11),
                "d", Arrays.asList(10, 16, 22),
                "e", Arrays.asList(20, 32, 44),
                "f", Arrays.asList(40, 64, 88),
                "g", Arrays.asList(80, 128, 176),
                "h", Arrays.asList(160, 256, 352)
        ).expect("#a + #b + #c + #d + #e + #f + #g = #h", (a, b, c, d, e, f, g, h) ->
                calculator.add(a, b, c, d, e, f, g) == h
        );
    }

    @TestFactory
    Expectations basicTest9Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .are(2, 3, 5, 10, 20, 40, 80, 160, 320)
                .and(3, 5, 8, 16, 32, 64, 128, 256, 512)
                .and(4, 7, 11, 22, 44, 88, 176, 352, 704)
                .expect("#a + #b + #c + #d + #e + #f + #g + #h = #i", (a, b, c, d, e, f, g, h, i) -> calculator.add(a, b, c, d, e, f, g, h) == i);
    }

    @Test
    void basicTest9FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d", "e", "f", "g", "h", "i")
                    .are(2, 3, 5, 10, 20, 40, 80, 160, 321)
                    .and(3, 5, 8, 16, 32, 64, 128, 256, 511)
                    .and(4, 7, 11, 22, 44, 88, 176, 352, 703)
                    .expect("#a + #b + #c + #d + #e + #f + #g + #h = #i", (a, b, c, d, e, f, g, h, i) -> calculator.add(a, b, c, d, e, f, g, h) == i)
                    .evaluate();
        });
    }

    @TestFactory
    Expectations basicTest9FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .are(2, 3, 5, 10, 20, 40, 80, 160, 320)
                .and(3, 5, 8, 16, 32, 64, 128, 256, 512)
                .and(4, 7, 11, 22, 44, 88, 176, 352, 704)
                .verify("#a + #b + #c + #d + #e + #f + #g + #h = #i", (a, b, c, d, e, f, g, h, i) ->
                        assertEquals((int) i, calculator.add(a, b, c, d, e, f, g, h))
                );
    }

    @TestFactory
    Expectations basicTest9WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .are(1, 1, 1, 1, 1, 1, 1, 1, 7)
                .and(2, 2, 2, 2, 2, 2, 2, 2, 15)
                .only(2, 3, 5, 10, 20, 40, 80, 160, 320)
                .and(999, 888, 777, 666, 555, 444, 333, 222, 111)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 + 333 + 222 != 111)
                .only(3, 5, 8, 16, 32, 64, 128, 256, 512)
                .and(100, 200, 300, 400, 500, 600, 700, 800, 900)  // This should be skipped - would fail if executed (100 + 200 + 300 + 400 + 500 + 600 + 700 + 800 != 900)
                .expect("#a + #b + #c + #d + #e + #f + #g + #h = #i", (a, b, c, d, e, f, g, h, i) -> calculator.add(a, b, c, d, e, f, g, h) == i);
    }

    @TestFactory
    Expectations basicTest9HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .only(2, 3, 5, 10, 20, 40, 80, 160, 320)
                .only(3, 5, 8, 16, 32, 64, 128, 256, 512)
                .and(999, 888, 777, 666, 555, 444, 333, 222, 111)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 + 333 + 222 != 111)
                .expect("#a + #b + #c + #d + #e + #f + #g + #h = #i", (a, b, c, d, e, f, g, h, i) -> calculator.add(a, b, c, d, e, f, g, h) == i);
    }

    @TestFactory
    Expectations basicTest9WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11),
                "d", Stream.of(10, 16, 22),
                "e", Stream.of(20, 32, 44),
                "f", Stream.of(40, 64, 88),
                "g", Stream.of(80, 128, 176),
                "h", Stream.of(160, 256, 352),
                "i", Stream.of(320, 512, 704)
        ).expect("#a + #b + #c + #d + #e + #f + #g + #h = #i", (a, b, c, d, e, f, g, h, i) ->
                calculator.add(a, b, c, d, e, f, g, h) == i
        );
    }

    @TestFactory
    Expectations basicTest9WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11),
                "d", Arrays.asList(10, 16, 22),
                "e", Arrays.asList(20, 32, 44),
                "f", Arrays.asList(40, 64, 88),
                "g", Arrays.asList(80, 128, 176),
                "h", Arrays.asList(160, 256, 352),
                "i", Arrays.asList(320, 512, 704)
        ).expect("#a + #b + #c + #d + #e + #f + #g + #h = #i", (a, b, c, d, e, f, g, h, i) ->
                calculator.add(a, b, c, d, e, f, g, h) == i
        );
    }

    @TestFactory
    Expectations basicTest10Fluent() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .are(2, 3, 5, 10, 20, 40, 80, 160, 320, 640)
                .and(3, 5, 8, 16, 32, 64, 128, 256, 512, 1024)
                .and(4, 7, 11, 22, 44, 88, 176, 352, 704, 1408)
                .expect("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) -> calculator.add(a, b, c, d, e, f, g, h, i) == j);
    }

    @TestFactory
    Expectations basicTest10FluentVerify() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .are(2, 3, 5, 10, 20, 40, 80, 160, 320, 640)
                .and(3, 5, 8, 16, 32, 64, 128, 256, 512, 1024)
                .and(4, 7, 11, 22, 44, 88, 176, 352, 704, 1408)
                .verify("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) ->
                        assertEquals((int) j, calculator.add(a, b, c, d, e, f, g, h, i))
                );
    }

    @TestFactory
    Expectations basicTest10WithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .are(1, 1, 1, 1, 1, 1, 1, 1, 1, 8)
                .and(2, 2, 2, 2, 2, 2, 2, 2, 2, 17)
                .only(2, 3, 5, 10, 20, 40, 80, 160, 320, 640)
                .and(999, 888, 777, 666, 555, 444, 333, 222, 111, 100)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 + 333 + 222 + 111 != 100)
                .only(3, 5, 8, 16, 32, 64, 128, 256, 512, 1024)
                .and(200, 300, 400, 500, 600, 700, 800, 900, 100, 200)  // This should be skipped - would fail if executed (200 + 300 + 400 + 500 + 600 + 700 + 800 + 900 + 100 != 200)
                .expect("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) -> calculator.add(a, b, c, d, e, f, g, h, i) == j);
    }

    @TestFactory
    Expectations basicTest10HeadersWithOnly() {
        Calculator calculator = new Calculator();

        return given("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .only(2, 3, 5, 10, 20, 40, 80, 160, 320, 640)
                .only(3, 5, 8, 16, 32, 64, 128, 256, 512, 1024)
                .and(999, 888, 777, 666, 555, 444, 333, 222, 111, 100)  // This should be skipped - would fail if executed (999 + 888 + 777 + 666 + 555 + 444 + 333 + 222 + 111 != 100)
                .expect("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) -> calculator.add(a, b, c, d, e, f, g, h, i) == j);
    }

    @Test
    void basicTest10FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                    .are(2, 3, 5, 10, 20, 40, 80, 160, 320, 641)
                    .and(3, 5, 8, 16, 32, 64, 128, 256, 512, 1025)
                    .and(4, 7, 11, 22, 44, 88, 176, 352, 704, 1409)
                    .expect("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) -> calculator.add(a, b, c, d, e, f, g, h, i) == j)
                    .evaluate();
        });
    }


    @TestFactory
    Expectations basicTest10WithStreams() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Stream.of(2, 3, 4),
                "b", Stream.of(3, 5, 7),
                "c", Stream.of(5, 8, 11),
                "d", Stream.of(10, 16, 22),
                "e", Stream.of(20, 32, 44),
                "f", Stream.of(40, 64, 88),
                "g", Stream.of(80, 128, 176),
                "h", Stream.of(160, 256, 352),
                "i", Stream.of(320, 512, 704),
                "j", Stream.of(640, 1024, 1408)
        ).expect("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) ->
                calculator.add(a, b, c, d, e, f, g, h, i) == j
        );
    }

    @TestFactory
    Expectations basicTest10WithIterables() {
        Calculator calculator = new Calculator();

        return Expectations.given(
                "a", Arrays.asList(2, 3, 4),
                "b", Arrays.asList(3, 5, 7),
                "c", Arrays.asList(5, 8, 11),
                "d", Arrays.asList(10, 16, 22),
                "e", Arrays.asList(20, 32, 44),
                "f", Arrays.asList(40, 64, 88),
                "g", Arrays.asList(80, 128, 176),
                "h", Arrays.asList(160, 256, 352),
                "i", Arrays.asList(320, 512, 704),
                "j", Arrays.asList(640, 1024, 1408)
        ).expect("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) ->
                calculator.add(a, b, c, d, e, f, g, h, i) == j
        );
    }

}
