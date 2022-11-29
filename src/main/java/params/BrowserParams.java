package params;

/**
 * contains all params that related to browser configuration.
 */
public final class BrowserParams {

    /**
     * default config for selenoid.
     */
    public static final String REMOTE_BROWSER_URL = "";
    public static final Integer BROWSER_TIMEOUT = 9_000;
    public static final String BROWSER_NAME = "firefox";
    public static final String BROWSER_VERSION = "90.0";

    private BrowserParams() {
    }
}
