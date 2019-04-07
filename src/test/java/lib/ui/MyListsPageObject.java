package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class MyListsPageObject extends MainPageObject
{
    protected static String
            FOLDER_BY_NAME_TML,
            ARTICLE_BY_TITLE_TML,
            ARTICLE_ID,
            READING_LISTS_BUTTON,
            ADD_READING_LIST_BUTTON,
            READING_LIST_NAME_FIELD,
            CREATE_READING_LIST_BUTTON;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TML.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
            return ARTICLE_BY_TITLE_TML.replace("{TITLE}", article_title);
        }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)

    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name '" + name_of_folder + "'",
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_title_xpath,
                "Cannot find saved article with title '" + article_title + "'",
                15
        );
    }

    public void waitForArticleToDissapearByTitle(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_title_xpath,
                "Saved article still present with title '" + article_title + "'",
                15
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_title_xpath,
                "Cannot find saved article"
        );
        if(Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_title_xpath, "Cannot find saved article");
        }
        this.waitForArticleToDissapearByTitle(article_title);
    }

    public String getTitleOfTheArticleFromTheList()
    {
        if (Platform.getInstance().isAndroid()) {
            return this.waitForElementAndGetAttribute(
                    ARTICLE_ID,
                    "text",
                    "Cannot find title of article",
                    15
            );
        } else {
            return this.waitForElementAndGetAttribute(
                    ARTICLE_ID,
                    "name",
                    "Cannot find title of article",
                    15
            );
        }
    }

    public void openReadingLists()
    {
        this.waitForElementAndClick(READING_LISTS_BUTTON, "Cannot find 'Reading lists' button", 10);
    }

    public void addNewReadingList(String name_of_folder)
    {
        this.waitForElementAndClick(ADD_READING_LIST_BUTTON, "Cannot find '+' button", 10);
        this.waitForElementAndSendKeys(READING_LIST_NAME_FIELD, name_of_folder, "Cannot find 'Reading list name' field", 10);
        this.waitForElementAndClick(CREATE_READING_LIST_BUTTON, "Cannot find 'Create reading list' button", 10);
    }


}
