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

import builders.dsl.expectations.dsl.Headers1;
import builders.dsl.expectations.dsl.Headers10;
import builders.dsl.expectations.dsl.Headers2;
import builders.dsl.expectations.dsl.Headers3;
import builders.dsl.expectations.dsl.Headers4;
import builders.dsl.expectations.dsl.Headers5;
import builders.dsl.expectations.dsl.Headers6;
import builders.dsl.expectations.dsl.Headers7;
import builders.dsl.expectations.dsl.Headers8;
import builders.dsl.expectations.dsl.Headers9;
import builders.dsl.expectations.dsl.DataTable1;
import builders.dsl.expectations.dsl.DataTable10;
import builders.dsl.expectations.dsl.DataTable2;
import builders.dsl.expectations.dsl.DataTable3;
import builders.dsl.expectations.dsl.DataTable4;
import builders.dsl.expectations.dsl.DataTable5;
import builders.dsl.expectations.dsl.DataTable6;
import builders.dsl.expectations.dsl.DataTable7;
import builders.dsl.expectations.dsl.DataTable8;
import builders.dsl.expectations.dsl.DataTable9;
import builders.dsl.expectations.dsl.Zip1;
import builders.dsl.expectations.dsl.Zip10;
import builders.dsl.expectations.dsl.Zip2;
import builders.dsl.expectations.dsl.Zip3;
import builders.dsl.expectations.dsl.Zip4;
import builders.dsl.expectations.dsl.Zip5;
import builders.dsl.expectations.dsl.Zip6;
import builders.dsl.expectations.dsl.Zip7;
import builders.dsl.expectations.dsl.Zip8;
import builders.dsl.expectations.dsl.Zip9;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.MultipleFailuresError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class is an entrypoint to easily create parametrized tests for JUnit 5.
 * <p>
 *     Use {@link Expectations} class as the return type of the method that is annotated with {@link org.junit.jupiter.api.TestFactory} to generate
 *     tests based on the data rows provided. The data rows are provided using one of the <code>given</code> methods.
 *
 *     <pre>
 *     &#064;TestFactory
 *     Expectations basicTest3Fluent() {
 *         Calculator calculator = new Calculator();
 *
 *         return given("a", "b", "c")
 *                 .are(2, 3, 5)
 *                 .and(3, 5, 8)
 *                 .and(4, 7, 11)
 *                 .expect(
 *                         "#a + #b = #c",
 *                         (a, b, c) -> calculator.add(a, b) == c
 *                 );
 *     }
 *     </pre>
 * </p>
 *
 * <p>
 *     if you need to evaluate immediately then you can call {@link #evaluate()} method. This can be useful when you want to
 *     need to verify multiple conditions in the middle of your test method or to create a stepwise tests with parametrized steps.
 * </p>
 */
public interface Expectations extends Iterable<DynamicContainer> {

    /**
     * Starts defining the data rows for the test with a single data column.
     * @param headerA the name of the first parameter
     * @return a builder for the data rows
     */
    static Headers1 given(String headerA) {
        return new Headers1(headerA);
    }

    /**
     * Starts defining the data rows for the test with two data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @return a builder for the data rows
     */
    static Headers2 given(String headerA, String headerB) {
        return new Headers2(headerA, headerB);
    }

    /**
     * Starts defining the data rows for the test with three data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @return a builder for the data rows
     */
    static Headers3 given(String headerA, String headerB, String headerC) {
        return new Headers3(headerA, headerB, headerC);
    }

    /**
     * Starts defining the data rows for the test with four data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @param headerD the name of the fourth parameter
     * @return a builder for the data rows
     */
    static Headers4 given(String headerA, String headerB, String headerC, String headerD) {
        return new Headers4(headerA, headerB, headerC, headerD);
    }

    /**
     * Starts defining the data rows for the test with five data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @param headerD the name of the fourth parameter
     * @param headerE the name of the fifth parameter
     * @return a builder for the data rows
     */
    static Headers5 given(String headerA, String headerB, String headerC, String headerD, String headerE) {
        return new Headers5(headerA, headerB, headerC, headerD, headerE);
    }

    /**
     * Starts defining the data rows for the test with six data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @param headerD the name of the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param headerF the name of the sixth parameter
     * @return a builder for the data rows
     */
    static Headers6 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF) {
        return new Headers6(headerA, headerB, headerC, headerD, headerE, headerF);
    }

    /**
     * Starts defining the data rows for the test with seven data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @param headerD the name of the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param headerG the name of the seventh parameter
     * @return a builder for the data rows
     */
    static Headers7 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG) {
        return new Headers7(headerA, headerB, headerC, headerD, headerE, headerF, headerG);
    }

    /**
     * Starts defining the data rows for the test with eight data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @param headerD the name of the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param headerH the name of the eighth parameter
     * @return a builder for the data rows
     */
    static Headers8 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG, String headerH) {
        return new Headers8(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH);
    }

    /**
     * Starts defining the data rows for the test with nine data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @param headerD the name of the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param headerI the name of the ninth parameter
     * @return a builder for the data rows
     */
    static Headers9 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG, String headerH, String headerI) {
        return new Headers9(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI);
    }

    /**
     * Starts defining the data rows for the test with ten data columns.
     * @param headerA the name of the first parameter
     * @param headerB the name of the second parameter
     * @param headerC the name of the third parameter
     * @param headerD the name of the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param headerI the name of the ninth parameter
     * @param headerJ the name of the tenth parameter
     * @return a builder for the data rows
     */
    static Headers10 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG, String headerH, String headerI, String headerJ) {
        return new Headers10(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI, headerJ);
    }

    /**
     * Starts defining the data rows for the test with a single data column.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @return a builder for the data rows that will contain the same number of rows as there are items in the iterable
     * @param <A> the type of the first parameter
     */
    static <A> DataTable1<A> given(String headerA, Iterable<A> valuesA) {
        return new DataTable1<>(new Headers1(headerA), new Zip1<>(valuesA.iterator()));
    }

    /**
     * Starts defining the data rows for the test with two data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     */
    static <A, B> DataTable2<A, B> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB) {
        return new DataTable2<>(new Headers2(headerA, headerB), new Zip2<>(valuesA.iterator(), valuesB.iterator()));
    }

    /**
     * Starts defining the data rows for the test with three data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     */
    static <A, B, C> DataTable3<A, B, C> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC) {
        return new DataTable3<>(new Headers3(headerA, headerB, headerC), new Zip3<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator()));
    }

    /**
     * Starts defining the data rows for the test with four data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     */
    static <A, B, C, D> DataTable4<A, B, C, D> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD) {
        return new DataTable4<>(new Headers4(headerA, headerB, headerC, headerD), new Zip4<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator()));
    }

    /**
     * Starts defining the data rows for the test with five data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     */
    static <A, B, C, D, E> DataTable5<A, B, C, D, E> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE) {
        return new DataTable5<>(new Headers5(headerA, headerB, headerC, headerD, headerE), new Zip5<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator()));
    }

    /**
     * Starts defining the data rows for the test with six data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     */
    static <A, B, C, D, E, F> DataTable6<A, B, C, D, E, F> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF) {
        return new DataTable6<>(new Headers6(headerA, headerB, headerC, headerD, headerE, headerF), new Zip6<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator()));
    }

    /**
     * Starts defining the data rows for the test with seven data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     * @param <G> the type of the seventh parameter
     */
    static <A, B, C, D, E, F, G> DataTable7<A, B, C, D, E, F, G> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG) {
        return new DataTable7<>(new Headers7(headerA, headerB, headerC, headerD, headerE, headerF, headerG), new Zip7<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator()));
    }

    /**
     * Starts defining the data rows for the test with eight data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param valuesH the values for the eighth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     * @param <G> the type of the seventh parameter
     * @param <H> the type of the eighth parameter
     */
    static <A, B, C, D, E, F, G, H> DataTable8<A, B, C, D, E, F, G, H> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG, String headerH, Iterable<H> valuesH) {
        return new DataTable8<>(new Headers8(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH), new Zip8<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator()));
    }

    /**
     * Starts defining the data rows for the test with nine data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param valuesH the values for the eighth parameter
     * @param headerI the name of the ninth parameter
     * @param valuesI the values for the ninth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
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
    static <A, B, C, D, E, F, G, H, I> DataTable9<A, B, C, D, E, F, G, H, I> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG, String headerH, Iterable<H> valuesH, String headerI, Iterable<I> valuesI) {
        return new DataTable9<>(new Headers9(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI), new Zip9<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator()));
    }

    /**
     * Starts defining the data rows for the test with ten data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param valuesH the values for the eighth parameter
     * @param headerI the name of the ninth parameter
     * @param valuesI the values for the ninth parameter
     * @param headerJ the name of the tenth parameter
     * @param valuesJ the values for the tenth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the shortest iterable
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     * @param <G> the type of the seventh parameter
     * @param <H> the type of the eighth parameter
     * @param <I> the type of the ninth parameter
     * @param <J> the type of the tenth parameter
     */
    static <A, B, C, D, E, F, G, H, I, J> DataTable10<A, B, C, D, E, F, G, H, I, J> given(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG, String headerH, Iterable<H> valuesH, String headerI, Iterable<I> valuesI, String headerJ, Iterable<J> valuesJ) {
        return new DataTable10<>(new Headers10(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI, headerJ), new Zip10<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator(), valuesJ.iterator()));
    }

    /**
     * Starts defining the data rows for the test with a single data column.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     */
    static <A> DataTable1<A> given(String headerA, Stream<A> valuesA) {
        return new DataTable1<>(new Headers1(headerA), new Zip1<>(valuesA.iterator()));
    }

    /**
     * Starts defining the data rows for the test with two data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     */
    static <A, B> DataTable2<A, B> given(String headerA, Stream<A> valuesA, String headerB, Stream<B> valuesB) {
        return new DataTable2<>(new Headers2(headerA, headerB), new Zip2<>(valuesA.iterator(), valuesB.iterator()));
    }

    /**
     * Starts defining the data rows for the test with three data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     */
    static <A, B, C> DataTable3<A, B, C> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC
    ) {
        return new DataTable3<>(new Headers3(headerA, headerB, headerC), new Zip3<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator()));
    }

    /**
     * Starts defining the data rows for the test with four data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     */
    static <A, B, C, D> DataTable4<A, B, C, D> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD
    ) {
        return new DataTable4<>(new Headers4(headerA, headerB, headerC, headerD), new Zip4<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator()));
    }

    /**
     * Starts defining the data rows for the test with five data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     */
    static <A, B, C, D, E> DataTable5<A, B, C, D, E> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD,
            String headerE,
            Stream<E> valuesE
    ) {
        return new DataTable5<>(new Headers5(headerA, headerB, headerC, headerD, headerE), new Zip5<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator()));
    }

    /**
     * Starts defining the data rows for the test with six data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     */
    static <A, B, C, D, E, F> DataTable6<A, B, C, D, E, F> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD,
            String headerE,
            Stream<E> valuesE,
            String headerF,
            Stream<F> valuesF
    ) {
        return new DataTable6<>(new Headers6(headerA, headerB, headerC, headerD, headerE, headerF), new Zip6<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator()));
    }

    /**
     * Starts defining the data rows for the test with seven data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     * @param <G> the type of the seventh parameter
     */
    static <A, B, C, D, E, F, G> DataTable7<A, B, C, D, E, F, G> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD,
            String headerE,
            Stream<E> valuesE,
            String headerF,
            Stream<F> valuesF,
            String headerG,
            Stream<G> valuesG
    ) {
        return new DataTable7<>(new Headers7(headerA, headerB, headerC, headerD, headerE, headerF, headerG), new Zip7<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator()));
    }

    /**
     * Starts defining the data rows for the test with eight data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param valuesH the values for the eighth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     * @param <G> the type of the seventh parameter
     * @param <H> the type of the eighth parameter
     */
    static <A, B, C, D, E, F, G, H> DataTable8<A, B, C, D, E, F, G, H> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD,
            String headerE,
            Stream<E> valuesE,
            String headerF,
            Stream<F> valuesF,
            String headerG,
            Stream<G> valuesG,
            String headerH,
            Stream<H> valuesH
    ) {
        return new DataTable8<>(new Headers8(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH), new Zip8<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator()));
    }

    /**
     * Starts defining the data rows for the test with nine data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param valuesH the values for the eighth parameter
     * @param headerI the name of the ninth parameter
     * @param valuesI the values for the ninth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
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
    static <A, B, C, D, E, F, G, H, I> DataTable9<A, B, C, D, E, F, G, H, I> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD,
            String headerE,
            Stream<E> valuesE,
            String headerF,
            Stream<F> valuesF,
            String headerG,
            Stream<G> valuesG,
            String headerH,
            Stream<H> valuesH,
            String headerI,
            Stream<I> valuesI
    ) {
        return new DataTable9<>(new Headers9(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI), new Zip9<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator()));
    }

    /**
     * Starts defining the data rows for the test with ten data columns.
     * @param headerA the name of the first parameter
     * @param valuesA the values for the first parameter
     * @param headerB the name of the second parameter
     * @param valuesB the values for the second parameter
     * @param headerC the name of the third parameter
     * @param valuesC the values for the third parameter
     * @param headerD the name of the fourth parameter
     * @param valuesD the values for the fourth parameter
     * @param headerE the name of the fifth parameter
     * @param valuesE the values for the fifth parameter
     * @param headerF the name of the sixth parameter
     * @param valuesF the values for the sixth parameter
     * @param headerG the name of the seventh parameter
     * @param valuesG the values for the seventh parameter
     * @param headerH the name of the eighth parameter
     * @param valuesH the values for the eighth parameter
     * @param headerI the name of the ninth parameter
     * @param valuesI the values for the ninth parameter
     * @param headerJ the name of the tenth parameter
     * @param valuesJ the values for the tenth parameter
     * @return a builder for the data rows that will contain at most the same number of rows as there are items in the stream with the smallest number elements
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the type of the third parameter
     * @param <D> the type of the fourth parameter
     * @param <E> the type of the fifth parameter
     * @param <F> the type of the sixth parameter
     * @param <G> the type of the seventh parameter
     * @param <H> the type of the eighth parameter
     * @param <I> the type of the ninth parameter
     * @param <J> the type of the tenth parameter
     */
    static <A, B, C, D, E, F, G, H, I, J> DataTable10<A, B, C, D, E, F, G, H, I, J> given(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD,
            String headerE,
            Stream<E> valuesE,
            String headerF,
            Stream<F> valuesF,
            String headerG,
            Stream<G> valuesG,
            String headerH,
            Stream<H> valuesH,
            String headerI,
            Stream<I> valuesI,
            String headerJ,
            Stream<J> valuesJ
    ) {
        return new DataTable10<>(new Headers10(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI, headerJ), new Zip10<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator(), valuesJ.iterator()));
    }

    /**
     * Immediately evaluates the expectations for all the rows of the data table and throws {@link MultipleFailuresError} if any of them fails.
     * @throws MultipleFailuresError if any of the rows fails
     */
    default void evaluate() {
        List<Throwable> errors = new ArrayList<>();
        iterator().forEachRemaining(container -> container.getChildren().filter(DynamicTest.class::isInstance).forEach(test -> {
            try {
                ((DynamicTest) test).getExecutable().execute();
            } catch (Throwable t) {
                errors.add(t);
            }
        }));
        if (!errors.isEmpty()) {
            throw new MultipleFailuresError("Verification failed", errors);
        }
    }

}
