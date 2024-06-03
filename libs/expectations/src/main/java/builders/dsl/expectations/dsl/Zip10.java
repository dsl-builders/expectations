package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip10<A, B, C, D, E, F, G, H, I, J> implements Iterable<Row10<A, B, C, D, E, F, G, H, I, J>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;
        private final Iterator<E> iteratorE;
        private final Iterator<F> iteratorF;
        private final Iterator<G> iteratorG;
        private final Iterator<H> iteratorH;
        private final Iterator<I> iteratorI;
        private final Iterator<J> iteratorJ;

        public Zip10(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD, Iterator<E> valuesE, Iterator<F> valuesF, Iterator<G> valuesG, Iterator<H> valuesH, Iterator<I> valuesI, Iterator<J> valuesJ) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
            this.iteratorE = valuesE;
            this.iteratorF = valuesF;
            this.iteratorG = valuesG;
            this.iteratorH = valuesH;
            this.iteratorI = valuesI;
            this.iteratorJ = valuesJ;
        }

        @Override
        public Iterator<Row10<A, B, C, D, E, F, G, H, I, J>> iterator() {
            return new Iterator<Row10<A, B, C, D, E, F, G, H, I, J>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext() && iteratorE.hasNext() && iteratorF.hasNext() && iteratorG.hasNext() && iteratorH.hasNext() && iteratorI.hasNext() && iteratorJ.hasNext();
                }

                @Override
                public Row10<A, B, C, D, E, F, G, H, I, J> next() {
                    return new Row10<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next(), iteratorE.next(), iteratorF.next(), iteratorG.next(), iteratorH.next(), iteratorI.next(), iteratorJ.next());
                }
            };
        }

}
