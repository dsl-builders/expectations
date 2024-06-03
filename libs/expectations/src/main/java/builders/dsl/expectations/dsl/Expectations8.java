package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Expectations8<A, B, C, D, E, F, G, H> implements Expectations {

        private final Where8<A, B, C, D, E, F, G, H> where;
        private final String template;
        private final Assertion8<A, B, C, D, E, F, G, H> verification;

        Expectations8(Where8<A, B, C, D, E, F, G, H> where, String template, Assertion8<A, B, C, D, E, F, G, H> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}