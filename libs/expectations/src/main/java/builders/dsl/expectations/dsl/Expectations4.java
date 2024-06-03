package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations4<A, B, C, D> implements Expectations {

        private final Where4<A, B, C, D> where;
        private final String template;
        private final Assertion4<A, B, C, D> verification;

        Expectations4(Where4<A, B, C, D> where, String template, Assertion4<A, B, C, D> verification) {
            this.where = where;
            this.template = template;
            this.verification = verification;
        }

        @Override
        public Iterator<DynamicContainer> iterator() {
            return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
        }

}