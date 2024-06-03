package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations7<A, B, C, D, E, F, G> implements Expectations {

        private final Where7<A, B, C, D, E, F, G> where;
        private final String template;
        private final Assertion7<A, B, C, D, E, F, G> verification;

        Expectations7(Where7<A, B, C, D, E, F, G> where, String template, Assertion7<A, B, C, D, E, F, G> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}