package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject
{
    protected static String
        MY_LISTS,
        EXPLORE_BUTTON,
        OPEN_NAVIGATION_MENU;

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigationMenu() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION_MENU, "Cannot find and click navigation menu button", 10);
        } else {
            System.out.println("Method openNavigationMenu() does nothing for platform " + Platform.getInstance().getPlatformVar());

        }
    }

    public void clickMyLists()
    {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttepmts(
                    MY_LISTS,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS,
                    "Cannot find navigation button to My list",
                    5
            );
        }
    }

    public void clickExplore()
    {
        this.waitForElementAndClick(EXPLORE_BUTTON, "Cannot find 'Explore' button", 10);
    }
}
