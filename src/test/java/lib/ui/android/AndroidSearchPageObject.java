package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{
            static {
                        SKIP_BUTTON_ONBOARDING_INIT_ELEMENT = "xpath://*[contains(@text, 'SKIP')]";
                        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
                        SEARCH_INPUT = "xpath://*[contains(@text,'Search Wikipedia')]";
                        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']//*[contains(text(),'{SUBSTRING}')]";
                        SEARCH_CANCEL_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_close_btn']";
                        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']";
                        NO_RESULTS_PLACEHOLDER = "xpath://*[@resource-id='org.wikipedia:id/search_empty_image']";
                        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TML = "xpath://android.widget.TextView[@text='{TITLE}']/following-sibling::android.widget.TextView[@text='{DESCRIPTION}']/..";
            }

    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


}
