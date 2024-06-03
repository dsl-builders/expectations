package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations3<A, B, C> implements Expectations {

    private final Where3<A, B, C> where;
    private final String template;
    private final Assertion3<A, B, C> verification;

    Expectations3(Where3<A, B, C> where, String template, Assertion3<A, B, C> verification) {
        this.where = where;
        this.template = template;
        this.verification = verification;
    }

    @Override
    public Iterator<DynamicContainer> iterator() {
        return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
    }

}





