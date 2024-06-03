package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations5<A, B, C, D, E> implements Expectations {

        private final Where5<A, B, C, D, E> where;
        private final String template;
        private final Assertion5<A, B, C, D, E> verification;

        Expectations5(Where5<A, B, C, D, E> where, String template, Assertion5<A, B, C, D, E> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}