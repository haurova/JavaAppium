package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject
{
    protected static String
            FOLDER_BY_NAME_TML,
            ARTICLE_BY_TITLE_TML,
            ARTICLE_ID,
            READING_LISTS_BUTTON,
            ADD_READING_LIST_BUTTON,
            READING_LIST_NAME_FIELD,
            CREATE_READING_LIST_BUTTON,
            REMOVE_FROM_SAVED_BUTTON;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TML.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
            return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
        }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TML.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(RemoteWebDriver driver)
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

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_title_xpath,
                "Saved article still present with title '" + article_title + "'",
                15
        );
    }

    public void swipeByArticleToDelete(String article_title) throws InterruptedException {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.waitForArticleToAppearByTitle(article_title);
            String article_title_xpath = getSavedArticleXpathByTitle(article_title);

            this.swipeElementToLeft(
                    article_title_xpath,
                    "Cannot find saved article"
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(remove_locator, "Cannot click button to remove article from saved", 5);
        }

        if(Platform.getInstance().isIOS()){
            String article_title_xpath = getSavedArticleXpathByTitle(article_title);
            this.clickElementToTheRightUpperCorner(article_title_xpath, "Cannot find saved article");
        }

        if(Platform.getInstance().isMW()) {
            Thread.sleep(5000);
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitle(article_title);
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
        } else if (Platform.getInstance().isIOS()){
            return this.waitForElementAndGetAttribute(
                    ARTICLE_ID,
                    "name",
                    "Cannot find title of article",
                    15
            );
        } else {
            return this.waitForElementAndGetAttribute(
                    ARTICLE_ID,
                    "title",
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
