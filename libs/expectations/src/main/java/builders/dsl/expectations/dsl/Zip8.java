package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip8<A, B, C, D, E, F, G, H> implements Iterable<Row8<A, B, C, D, E, F, G, H>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;
        private final Iterator<F> iteratorF;
        private final Iterator<G> iteratorG;
        private final Iterator<H> iteratorH;

        public Zip8(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF, Iterator<G> valuesG, Iterator<H> valuesH) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
            this.iteratorF = valuesF;
            this.iteratorG = valuesG;
            this.iteratorH = valuesH;
        }

        @Override
        public Iterator<Row8<A, B, C, D, E, F, G, H>> iterator() {
            return new Iterator<Row8<A, B, C, D, E, F, G, H>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext() && iteratorG.hasNext() && iteratorH.hasNext();
                }

                @Override
                public Row8<A, B, C, D, E, F, G, H> next() {
                    return new Row8<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next(), iteratorG.next(), iteratorH.next());
                }
            };
        }

}
