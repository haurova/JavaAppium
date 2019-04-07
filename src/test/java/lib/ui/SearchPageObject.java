package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.Platform;

abstract public class SearchPageObject extends MainPageObject
{

     protected static String
        SKIP_BUTTON_ONBOARDING_INIT_ELEMENT,
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT,
        SEARCH_RESULT_BY_SUBSTRING_TPL,
        SEARCH_CANCEL_BUTTON,
        SEARCH_RESULT_ELEMENT,
        NO_RESULTS_PLACEHOLDER,
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TML,
        CLEAR_BUTTON;


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);

    }

    /* TEMPLATE METHODS */
    private static String getSearchResultElement(String subsctring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", subsctring);
    }

    private static String getSearchResultElementbyTitleAndDescription(String title, String description)
    {
        return SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TML
                .replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);
    }
    /* TEMPLATE METHODS */

    public void skipOnboarding()
    {
        this.waitForElementAndClick(SKIP_BUTTON_ONBOARDING_INIT_ELEMENT, "Cannot find 'Skip' button", 5);

    }

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init elements", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking on it");

    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find search input to type",5);

    }

    public void waitForCancelButtonAppear()
    {
     this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find 'X' button", 5);
    }

    public void waitForCancelButtonDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "'X' button still displayed", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click 'X' button", 5);
    }

    public void clearSearch()
    {
        this.waitForElementAndClick(CLEAR_BUTTON, "Cannot find tiny 'x' button", 10);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getSearchResultElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring" + substring);
    }

    public void waitForElementByTitleAndDescription(String title, String description)
    {
        String search_result_xpath = getSearchResultElementbyTitleAndDescription(title, description);
        this.waitForElementPresent(
                search_result_xpath,
                "Cannot find search result with title '" + title + "' " + "and description '" + description + "'");
    }

    public void clickbyArticleWithSubstring(String substring)
    {
        String search_result_xpath = getSearchResultElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring '" + substring + "'", 10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request",
                15
        );

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

     }

    public void waitForNoResultsPlaceholderImage()
    {
        this.waitForElementPresent(NO_RESULTS_PLACEHOLDER, "Search is not empty or there is no placeholder image displayed");
    }
}
