package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations6<A, B, C, D, E, F> implements Expectations {

        private final Where6<A, B, C, D, E, F> where;
        private final String template;
        private final Assertion6<A, B, C, D, E, F> verification;

        Expectations6(Where6<A, B, C, D, E, F> where, String template, Assertion6<A, B, C, D, E, F> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}