package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.openqa.selenium.ScreenOrientation;


public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        if (Platform.getInstance().isIOS()) {
            this.skipOnboardingForIOS();
        } else {
            SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
            SearchPageObject.skipOnboarding();
        }
    }

    @Override
    protected void tearDown() throws Exception
    {

        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);

    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);

    }

    protected void sendAppToBackground(int seconds)
    {
        driver.runAppInBackground(seconds);

    }

    private void skipOnboardingForIOS()
    {
        if(Platform.getInstance().isIOS()) {
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }
}
