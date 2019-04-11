package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;


public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        if (Platform.getInstance().isIOS()) {
            this.skipOnboardingForIOS();
        } else if (Platform.getInstance().isAndroid()) {
            SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
            SearchPageObject.skipOnboarding();
        }
        this.openWikiWebPageForMobileWeb();
    }

    @Override
    protected void tearDown() throws Exception
    {

        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void rotateScreenLandscape()
    {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected void sendAppToBackground(int seconds)
    {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(seconds);
        } else {
            System.out.println("Method sendAppToBackground() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected void openWikiWebPageForMobileWeb()
    {
        if (Platform.getInstance().isMW()) {
            driver.get("https://en.m.wikipedia.org");
        }  else {
            System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());

        }
    }

    private void skipOnboardingForIOS()
    {
        if(Platform.getInstance().isIOS()) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }
}
