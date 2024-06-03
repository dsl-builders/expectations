package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip5<A, B, C, D, E> implements Iterable<Row5<A, B, C, D, E>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;

        public Zip5(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
        }

        @Override
        public Iterator<Row5<A, B, C, D, E>> iterator() {
            return new Iterator<Row5<A, B, C, D, E>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext();
                }

                @Override
                public Row5<A, B, C, D, E> next() {
                    return new Row5<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next());
                }
            };
        }

}
