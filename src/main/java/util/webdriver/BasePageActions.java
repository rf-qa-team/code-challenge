package util.webdriver;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static params.BrowserParams.BROWSER_TIMEOUT;
import static util.webdriver.Browser.setup;

/**
 * contains all methods that related to browser ui testing.
 */
public final class BasePageActions {
    private BasePageActions() {
    }

    /**
     * Open browser with URL.
     *
     * @param url -string url that should be opened.
     */
    public static void openUrl(String url) {
        setup(); // comment this for running on local browser.
        Allure.step(String.format("Navigating to: " + url));
        open(url);
    }

    /**
     * wait and click on visible element.
     *
     * @param elem SelenideElement.
     */
    public static void clickOnElement(SelenideElement elem) {
        Allure.step(String.format("Clicking on: " + elem.name()));
        elem.shouldBe(exist, Duration.ofMillis(BROWSER_TIMEOUT)).click();
    }

    public static void doubleClickOnElementAndEnterText(SelenideElement elem, String text) {
        Allure.step(String.format("Double clicking on: " + elem.name()));
        elem.shouldBe(exist, Duration.ofMillis(BROWSER_TIMEOUT)).doubleClick()
            .clear();
        elem.setValue(text);
    }

    /**
     * set data to visible element.
     *
     * @param elem Selenide element.
     * @param data string text that should be filled to field.
     */
    public static void setDataToField(SelenideElement elem, String data) {
        Allure.step(String.format("Setting value: " + data + " to " + elem.name()));
        elem.shouldBe(exist, Duration.ofMillis(BROWSER_TIMEOUT)).setValue(data);
    }

    public static void pressReturnKey(SelenideElement elem) {
        Allure.step("Pressing Return Key");
        elem.shouldBe(exist, Duration.ofMillis(BROWSER_TIMEOUT)).pressEnter();
    }

    /**
     * wait for n-seconds for the elent existing status.
     * @param element Selenide element.
     * @param timeout long time waiting for element exist.
     * @return bolean existing status.
     */
    public static boolean isElementExistPerTimeout(SelenideElement element, long timeout) {
        long t = System.currentTimeMillis();
        long end = t + timeout;
        boolean k = false;
        while (System.currentTimeMillis() < end) {
            k = element.is(visible);
            if (k) {
                break;
            }
        }
        return k;
    }
}
