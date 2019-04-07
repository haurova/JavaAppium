package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static
    {
        FOLDER_BY_NAME_TML = "xpath://android.widget.TextView[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TML = "xpath://android.widget.TextView[@text='{TITLE}']";
        ARTICLE_ID = "id:org.wikipedia:id/page_list_item_title";
    }

    public AndroidMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
