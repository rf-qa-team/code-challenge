package util.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static params.BrowserParams.*;

/**
 * remote browser configuration.
 */
public class CustomProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setBrowserName(BROWSER_NAME);
        capabilities.setVersion(BROWSER_VERSION);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("headless", false);
        capabilities.setAcceptInsecureCerts(true);
        try {
            return new RemoteWebDriver(new URL(REMOTE_BROWSER_URL), capabilities);
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to create driver", e);
        }
    }
}