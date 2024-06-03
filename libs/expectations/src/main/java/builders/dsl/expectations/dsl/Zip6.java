package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip6<A, B, C, D, E, F> implements Iterable<Row6<A, B, C, D, E, F>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;
        private final Iterator<F> iteratorF;

        public Zip6(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
            this.iteratorF = valuesF;
        }

        @Override
        public Iterator<Row6<A, B, C, D, E, F>> iterator() {
            return new Iterator<Row6<A, B, C, D, E, F>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext();
                }

                @Override
                public Row6<A, B, C, D, E, F> next() {
                    return new Row6<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next());
                }
            };
        }

}