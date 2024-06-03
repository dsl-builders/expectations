package builders.dsl.expectations;

import builders.dsl.expectations.dsl.*;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.opentest4j.MultipleFailuresError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public interface Expectations extends Iterable<DynamicContainer> {

    static Headers1 given(String headerA) {
        return new Headers1(headerA);
    }

    static Headers2 given(String headerA, String headerB) {
        return new Headers2(headerA, headerB);
    }

    static Headers3 given(String headerA, String headerB, String headerC) {
        return new Headers3(headerA, headerB, headerC);
    }

    static Headers4 given(String headerA, String headerB, String headerC, String headerD) {
        return new Headers4(headerA, headerB, headerC, headerD);
    }

    static Headers5 given(String headerA, String headerB, String headerC, String headerD, String headerE) {
        return new Headers5(headerA, headerB, headerC, headerD, headerE);
    }

    static Headers6 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF) {
        return new Headers6(headerA, headerB, headerC, headerD, headerE, headerF);
    }

    static Headers7 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG) {
        return new Headers7(headerA, headerB, headerC, headerD, headerE, headerF, headerG);
    }

    static Headers8 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG, String headerH) {
        return new Headers8(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH);
    }

    static Headers9 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG, String headerH, String headerI) {
        return new Headers9(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI);
    }

    static Headers10 given(String headerA, String headerB, String headerC, String headerD, String headerE, String headerF, String headerG, String headerH, String headerI, String headerJ) {
        return new Headers10(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI, headerJ);
    }

    static <A> Where1<A> forEach(String headerA, Iterable<A> valuesA) {
        return new Where1<>(new Headers1(headerA), new Zip1<>(valuesA.iterator()));
    }

    static <A, B> Where2<A, B> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB) {
        return new Where2<>(new Headers2(headerA, headerB), new Zip2<>(valuesA.iterator(), valuesB.iterator()));
    }

    static <A, B, C> Where3<A, B, C> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC) {
        return new Where3<>(new Headers3(headerA, headerB, headerC), new Zip3<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator()));
    }

    static <A, B, C, D> Where4<A, B, C, D> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD) {
        return new Where4<>(new Headers4(headerA, headerB, headerC, headerD), new Zip4<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator()));
    }

    static <A, B, C, D, E> Where5<A, B, C, D, E> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE) {
        return new Where5<>(new Headers5(headerA, headerB, headerC, headerD, headerE), new Zip5<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator()));
    }

    static <A, B, C, D, E, F> Where6<A, B, C, D, E, F> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF) {
        return new Where6<>(new Headers6(headerA, headerB, headerC, headerD, headerE, headerF), new Zip6<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator()));
    }

    static <A, B, C, D, E, F, G> Where7<A, B, C, D, E, F, G> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG) {
        return new Where7<>(new Headers7(headerA, headerB, headerC, headerD, headerE, headerF, headerG), new Zip7<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator()));
    }

    static <A, B, C, D, E, F, G, H> Where8<A, B, C, D, E, F, G, H> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG, String headerH, Iterable<H> valuesH) {
        return new Where8<>(new Headers8(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH), new Zip8<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator()));
    }

    static <A, B, C, D, E, F, G, H, I> Where9<A, B, C, D, E, F, G, H, I> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG, String headerH, Iterable<H> valuesH, String headerI, Iterable<I> valuesI) {
        return new Where9<>(new Headers9(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI), new Zip9<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator()));
    }

    static <A, B, C, D, E, F, G, H, I, J> Where10<A, B, C, D, E, F, G, H, I, J> forEach(String headerA, Iterable<A> valuesA, String headerB, Iterable<B> valuesB, String headerC, Iterable<C> valuesC, String headerD, Iterable<D> valuesD, String headerE, Iterable<E> valuesE, String headerF, Iterable<F> valuesF, String headerG, Iterable<G> valuesG, String headerH, Iterable<H> valuesH, String headerI, Iterable<I> valuesI, String headerJ, Iterable<J> valuesJ) {
        return new Where10<>(new Headers10(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI, headerJ), new Zip10<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator(), valuesJ.iterator()));
    }

    static <A> Where1<A> forEach(String headerA, Stream<A> valuesA) {
        return new Where1<>(new Headers1(headerA), new Zip1<>(valuesA.iterator()));
    }

    static <A, B> Where2<A, B> forEach(String headerA, Stream<A> valuesA, String headerB, Stream<B> valuesB) {
        return new Where2<>(new Headers2(headerA, headerB), new Zip2<>(valuesA.iterator(), valuesB.iterator()));
    }

    static <A, B, C> Where3<A, B, C> forEach(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC
    ) {
        return new Where3<>(new Headers3(headerA, headerB, headerC), new Zip3<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator()));
    }

    static <A, B, C, D> Where4<A, B, C, D> forEach(
            String headerA,
            Stream<A> valuesA,
            String headerB,
            Stream<B> valuesB,
            String headerC,
            Stream<C> valuesC,
            String headerD,
            Stream<D> valuesD
    ) {
        return new Where4<>(new Headers4(headerA, headerB, headerC, headerD), new Zip4<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator()));
    }

    static <A, B, C, D, E> Where5<A, B, C, D, E> forEach(
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
        return new Where5<>(new Headers5(headerA, headerB, headerC, headerD, headerE), new Zip5<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator()));
    }

    static <A, B, C, D, E, F> Where6<A, B, C, D, E, F> forEach(
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
        return new Where6<>(new Headers6(headerA, headerB, headerC, headerD, headerE, headerF), new Zip6<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator()));
    }

    static <A, B, C, D, E, F, G> Where7<A, B, C, D, E, F, G> forEach(
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
        return new Where7<>(new Headers7(headerA, headerB, headerC, headerD, headerE, headerF, headerG), new Zip7<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator()));
    }

    static <A, B, C, D, E, F, G, H> Where8<A, B, C, D, E, F, G, H> forEach(
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
        return new Where8<>(new Headers8(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH), new Zip8<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator()));
    }

    static <A, B, C, D, E, F, G, H, I> Where9<A, B, C, D, E, F, G, H, I> forEach(
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
        return new Where9<>(new Headers9(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI), new Zip9<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator()));
    }

    static <A, B, C, D, E, F, G, H, I, J> Where10<A, B, C, D, E, F, G, H, I, J> forEach(
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
        return new Where10<>(new Headers10(headerA, headerB, headerC, headerD, headerE, headerF, headerG, headerH, headerI, headerJ), new Zip10<>(valuesA.iterator(), valuesB.iterator(), valuesC.iterator(), valuesD.iterator(), valuesE.iterator(), valuesF.iterator(), valuesG.iterator(), valuesH.iterator(), valuesI.iterator(), valuesJ.iterator()));
    }

    default void verify() {
        List<Throwable> errors = new ArrayList<>();
        iterator().forEachRemaining(container -> {
            container.getChildren().filter(DynamicTest.class::isInstance).forEach(test -> {
                try {
                    ((DynamicTest) test).getExecutable().execute();
                } catch (Throwable t) {
                    errors.add(t);
                }
            });
        });
        if (!errors.isEmpty()) {
            throw new MultipleFailuresError("Verification failed", errors);
        }
    }

}
