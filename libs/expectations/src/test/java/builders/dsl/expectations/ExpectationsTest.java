package builders.dsl.expectations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.opentest4j.MultipleFailuresError;

import java.util.Arrays;
import java.util.stream.Stream;

import static builders.dsl.expectations.Expectations.given;
import static builders.dsl.expectations.Expectations.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpectationsTest {

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
                .verify();
    }

    @Test
    void basicTest1FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a")
                    .is(4)
                    .and(3)
                    .expect("#a + 1 = #a", a -> calculator.add(a, 1) == a)
                    .verify();
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
                    .verify();
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
                    .verify();                                                          // <2>
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
                    .verify();
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
                    .verify();
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
                    .verify();
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
                    .verify();
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
                    .verify();
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
                    .verify();
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

    @Test
    void basicTest10FluentFails() {
        Assertions.assertThrows(MultipleFailuresError.class, () -> {
            Calculator calculator = new Calculator();

            given("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                    .are(2, 3, 5, 10, 20, 40, 80, 160, 320, 641)
                    .and(3, 5, 8, 16, 32, 64, 128, 256, 512, 1025)
                    .and(4, 7, 11, 22, 44, 88, 176, 352, 704, 1409)
                    .expect("#a + #b + #c + #d + #e + #f + #g + #h + #i = #j", (a, b, c, d, e, f, g, h, i, j) -> calculator.add(a, b, c, d, e, f, g, h, i) == j)
                    .verify();
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
