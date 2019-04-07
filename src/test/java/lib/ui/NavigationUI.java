package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject
{
    protected static String
        MY_LISTS,
        EXPLORE_BUTTON;

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                MY_LISTS,
                "Cannot find 'My lists' button",
                5
        );
    }

    public void clickExplore()
    {
        this.waitForElementAndClick(EXPLORE_BUTTON, "Cannot find 'Explore' button", 10);
    }
}
