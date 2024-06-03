package builders.dsl.expectations.dsl;

import builders.dsl.expectations.Expectations;
import org.junit.jupiter.api.DynamicContainer;

import java.util.Collections;
import java.util.Iterator;

public class Expectations1<A> implements Expectations {

    private final Where1<A> where;
    private final String template;
    private final Assertion1<A> verification;

    Expectations1(Where1<A> where, String template, Assertion1<A> verification) {
        this.where = where;
        this.template = template;
        this.verification = verification;
    }

    @Override
    public Iterator<DynamicContainer> iterator() {
        return Collections.singleton(DynamicContainer.dynamicContainer(template, where.generateTests(template, verification))).iterator();
    }

}