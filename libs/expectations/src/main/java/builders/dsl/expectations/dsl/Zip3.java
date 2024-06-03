package builders.dsl.expectations.dsl;

import java.util.Iterator;

public class Zip3<A, B, C> implements Iterable<Row3<A, B, C>>{

    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;
    private final Iterator<C> iteratorC;

    public Zip3(Iterator<A> valuesA, Iterator<B> valuesB, Iterator<C> valuesC) {
        this.iteratorA = valuesA;
        this.iteratorB = valuesB;
        this.iteratorC = valuesC;
    }

    @Override
    public Iterator<Row3<A, B, C>> iterator() {
        return new Iterator<Row3<A, B, C>>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext() && iteratorC.hasNext();
            }

            @Override
            public Row3<A, B, C> next() {
                return new Row3<>(iteratorA.next(), iteratorB.next(), iteratorC.next());
            }
        };
    }

}

