package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip4<A, B, C, D> implements Iterable<Row4<A, B, C, D>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;
        private final Iterator<C> iteratorC;
        private final Iterator<D> iteratorD;

        public Zip4(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC, Iterator<D> valuesD) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
            this.iteratorC = valuesC;
            this.iteratorD = valuesD;
        }

        @Override
        public Iterator<Row4<A, B, C, D>> iterator() {
            return new Iterator<Row4<A, B, C, D>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext() && iteratorD.hasNext();
                }

                @Override
                public Row4<A, B, C, D> next() {
                    return new Row4<>(iteratorA.next(), iteratorB.next(), iteratorC.next(), iteratorD.next());
                }
            };
        }

}
