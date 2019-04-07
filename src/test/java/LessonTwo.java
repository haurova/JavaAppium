import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class LessonTwo
{
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/haurova/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void exerciseTwo()
    {
        /* На моём устройстве постоянно показывается онбординг, поэтому приходится каждый раз его пропускать */
        waitForElementAndClick(
                    By.xpath("//*[contains(@text, 'Skip')]"),
                    "Cannot find 'Skip' button",
                    5
            );

        waitForElementAndClick(
                    By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                    "Cannot find search input",
                    5
            );
        waitForElementPresent(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Cannot find text 'Search...'",
                5
                );
    }

    @Test
    public void exerciseThree()
    {
        /* На моём устройстве постоянно показывается онбординг, поэтому приходится каждый раз его пропускать */
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot find 'Skip' button",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Tea",
                "Cannot find search input",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='Drink made from infusing boiling water with the leaves of the tea plant']"),
                "Can't find article 'Tea'",
                15
                );

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='Person who helps others to acquire knowledge, competences or values']"),
                "Can't find article 'Teacher'",
                15
        );

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='American political movement']"),
                "Can't find article 'Tea Party Movement'",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_close_btn']"),
                "Cannot find X to cancel search",
                5
        );

        /* Ищу изображение-плейсхолдер, отображающееся на пустой странице поиска */
        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_empty_image']"),
                "The search is not empty",
                15
        );

    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


}
