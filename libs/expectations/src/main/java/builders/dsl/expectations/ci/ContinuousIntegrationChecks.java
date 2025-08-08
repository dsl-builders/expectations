package builders.dsl.expectations.ci;

/**
 * This class provides utility methods to check if the code is running in a Continuous Integration (CI) environment
 * and to control the usage of the 'only' feature in tests.
 * <p>
 * The 'only' feature is used to run only specific tests in a data table, but it is not allowed in CI environments
 * to ensure that all tests are run.
 */
public class ContinuousIntegrationChecks {

    /**
     * If set to <code>true</code>, the 'only' feature is allowed.
     * If set to <code>false</code>, the 'only' feature is not allowed and will throw an exception if used.
     */
    private static boolean onlyAllowed = !isRunningCI();

    public static boolean isOnlyAllowed() {
        return onlyAllowed;
    }

    public static void setOnlyAllowed(boolean onlyAllowed) {
        ContinuousIntegrationChecks.onlyAllowed = onlyAllowed;
    }

    /**
     * Checks if the code is running in a Continuous Integration (CI) environment.
     * This is typically determined by the presence of the "CI" environment variable.
     *
     * @return <code>true</code> if running in CI, <code>false</code> otherwise
     */
    public static boolean isRunningCI() {
        return System.getenv("CI") != null;
    }

    /**
     * Checks if the 'only' feature is allowed.
     * If the 'only' feature is not allowed, it throws an IllegalStateException.
     *
     * @throws IllegalStateException if the 'only' feature is not allowed
     */
    public static void checkOnlyAllowed() {
        if (onlyAllowed) {
            return;
        }
        throw new IllegalStateException("The 'only' feature is not allowed in CI environment. Please remove the 'only' flag from the test.");
    }

    private ContinuousIntegrationChecks() {
        // utility class
    }

}
