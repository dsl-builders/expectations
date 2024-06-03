package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations10<A, B, C, D, E, F, G, H, I, J> implements Expectations {

        private final Where10<A, B, C, D, E, F, G, H, I, J> where;
        private final String template;
        private final Assertion10<A, B, C, D, E, F, G, H, I, J> verification;

        Expectations10(Where10<A, B, C, D, E, F, G, H, I, J> where, String template, Assertion10<A, B, C, D, E, F, G, H, I, J> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}