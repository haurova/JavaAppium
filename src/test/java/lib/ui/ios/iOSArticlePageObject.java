package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {

        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        READING_LIST_BUTTON = "id:Save for later";
        BACK_BUTTON = "id:Back";
        NO_THANKS_BUTTON_SYNC_POPUP = "id:places auth close";
        ADD_TO_READING_LIST_BUTTON = "xpath://XCUIElementTypeImage[@name='add-to-list']/../../../..";
        NAME_OF_EXISTING_FOLDER_TML = "xpath://XCUIElementTypeLink[@name='{FOLDER_NAME}']";
        TOOLBAR = "xpath://XCUIElementTypeToolbar";

    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
