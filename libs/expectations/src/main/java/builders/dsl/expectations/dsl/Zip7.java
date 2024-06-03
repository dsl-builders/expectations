package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip7<A, B, C, D, E, F, G> implements Iterable<Row7<A, B, C, D, E, F, G>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;
        private final Iterator<F> iteratorF;
        private final Iterator<G> iteratorG;

        public Zip7(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF, Iterator<G> valuesG) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
            this.iteratorF = valuesF;
            this.iteratorG = valuesG;
        }

        @Override
        public Iterator<Row7<A, B, C, D, E, F, G>> iterator() {
            return new Iterator<Row7<A, B, C, D, E, F, G>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext() && iteratorG.hasNext();
                }

                @Override
                public Row7<A, B, C, D, E, F, G> next() {
                    return new Row7<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next(), iteratorG.next());
                }
            };
        }

}
