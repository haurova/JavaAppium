package lib.ui.ios;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObjects extends MyListsPageObject {

    static
    {
        ARTICLE_BY_TITLE_TML = "xpath://XCUIElementTypeLink[@name='{TITLE}']";
        ARTICLE_ID = "xpath://XCUIElementTypeLink";
        READING_LISTS_BUTTON = "id:Reading lists";
        ADD_READING_LIST_BUTTON = "id:Add";
        READING_LIST_NAME_FIELD = "xpath://XCUIElementTypeTextField[@value='reading list title']/..";
        CREATE_READING_LIST_BUTTON = "id:Create reading list";
        FOLDER_BY_NAME_TML = "xpath://XCUIElementTypeLink[@name='{FOLDER_NAME}']";
    }

    public iOSMyListsPageObjects(RemoteWebDriver driver)
    {
        super(driver);
    }
}