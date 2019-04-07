package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

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

    public iOSMyListsPageObjects(AppiumDriver driver)
    {
        super(driver);
    }
}