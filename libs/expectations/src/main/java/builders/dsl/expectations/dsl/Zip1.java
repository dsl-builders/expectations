package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip1<A> implements Iterable<Row1<A>> {

        private final Iterator<A> iteratorA;

        public Zip1(Iterator<A> valuesA) {
            this.iteratorA = valuesA;
        }

        @Override
        public Iterator<Row1<A>> iterator() {
            return new Iterator<Row1<A>>() {
                @Override
                public boolean hasNext() {
                    return iteratorA.hasNext();
                }

                @Override
                public Row1<A> next() {
                    return new Row1<>(iteratorA.next());
                }
            };
        }

}
