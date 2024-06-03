package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip2<A, B> implements Iterable<Row2<A, B>> {

        private final Iterator<A> iteratorA;
        private final Iterator<B> iteratorB;

        public Zip2(Iterator<A> valuesA, Iterator<B> valuesB) {
            this.iteratorA = valuesA;
            this.iteratorB = valuesB;
        }

        @Override
        public Iterator<Row2<A, B>> iterator() {
            return new Iterator<Row2<A, B>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext() && iteratorB.hasNext();
                }

                @Override
                public Row2<A, B> next() {
                    return new Row2<>(iteratorA.next(), iteratorB.next());
                }
            };
        }

}
