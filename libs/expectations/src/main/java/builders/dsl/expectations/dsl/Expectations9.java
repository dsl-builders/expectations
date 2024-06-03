package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations9<A, B, C, D, E, F, G, H, I> implements Expectations {

        private final Where9<A, B, C, D, E, F, G, H, I> where;
        private final String template;
        private final Assertion9<A, B, C, D, E, F, G, H, I> verification;

        Expectations9(Where9<A, B, C, D, E, F, G, H, I> where, String template, Assertion9<A, B, C, D, E, F, G, H, I> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}