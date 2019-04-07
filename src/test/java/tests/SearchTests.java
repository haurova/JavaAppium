package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class SearchTests extends CoreTestCase
{

    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        //SearchPageObject.skipOnboarding();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }

    @Test
    public void testCancelSearch()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.skipOnboarding();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonDisappear();

    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.skipOnboarding();
        SearchPageObject.initSearchInput();

        String search_line = "Linkin park discography";

        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }

    /** Ex3: Тест: отмена поиска */
    @Test
    public void testSearchCancellation()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.skipOnboarding();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Tea");
        SearchPageObject.waitForSearchResult("Drink made from infusing boiling water with the leaves of the tea plant");
        SearchPageObject.waitForSearchResult("Person who helps others to acquire knowledge, competences or values");
        SearchPageObject.waitForSearchResult("American political movement");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForNoResultsPlaceholderImage();

    }

    /** Ex9: Рефакторинг темплейта */
    @Test
    public void test() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.skipOnboarding();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Back");
        SearchPageObject.waitForElementByTitleAndDescription("Human back", "Redirected from Back");
        SearchPageObject.waitForElementByTitleAndDescription("Backstreet Boys", "American vocal harmony group");
        SearchPageObject.waitForElementByTitleAndDescription("Back to the Future", "1985 film by Robert Zemeckis");

    }

}
