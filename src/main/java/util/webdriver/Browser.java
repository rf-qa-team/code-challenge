package util.webdriver;

import com.codeborne.selenide.Configuration;

import static params.BrowserParams.BROWSER_TIMEOUT;

/**
 * browser configuration.
 */
public final class Browser {
    private Browser() {
    }

    public static void setup() {
        Configuration.baseUrl = "";
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = BROWSER_TIMEOUT;
        Configuration.driverManagerEnabled = false;
        Configuration.browser = CustomProvider.class.getName();
    }
}
