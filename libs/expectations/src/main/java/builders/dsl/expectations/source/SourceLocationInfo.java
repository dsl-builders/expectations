package builders.dsl.expectations.source;

/**
 * The sole purpose of this class is to be added as suppressed exception when the parameterized test fails.
 */
public class SourceLocationInfo extends RuntimeException {

    public SourceLocationInfo(SourceLocation location) {
        super("Data row: " + location);
    }

}
