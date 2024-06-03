package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip9<A, B, C, D, E, F, G, H, I> implements Iterable<Row9<A, B, C, D, E, F, G, H, I>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;
        private final Iterator<F> iteratorF;
        private final Iterator<G> iteratorG;
        private final Iterator<H> iteratorH;
        private final Iterator<I> iteratorI;

        public Zip9(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF, Iterator<G> valuesG, Iterator<H> valuesH, Iterator<I> valuesI) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
            this.iteratorF = valuesF;
            this.iteratorG = valuesG;
            this.iteratorH = valuesH;
            this.iteratorI = valuesI;
        }

        @Override
        public Iterator<Row9<A, B, C, D, E, F, G, H, I>> iterator() {
            return new Iterator<Row9<A, B, C, D, E, F, G, H, I>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext() && iteratorG.hasNext() && iteratorH.hasNext() && iteratorI.hasNext();
                }

                @Override
                public Row9<A, B, C, D, E, F, G, H, I> next() {
                    return new Row9<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next(), iteratorG.next(), iteratorH.next(), iteratorI.next());
                }
            };
        }

}