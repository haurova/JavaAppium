package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject

{
    static {
        SKIP_BUTTON_ONBOARDING_INIT_ELEMENT = "xpath://*[contains(@text, 'Skip')]";
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name = 'Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value = 'Search Wikipedia']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        NO_RESULTS_PLACEHOLDER = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TML = "xpath://android.widget.TextView[@text='{TITLE}']/following-sibling::android.widget.TextView[@text='{DESCRIPTION}']/..";
        CLEAR_BUTTON = "id:clear mini";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
