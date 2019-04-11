package lib.ui.android;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject
{

    static {

        TITLE = "xpath://*android.webkit.WebView/android.webkit.WebView/android.view.View[1]";
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
        READING_LIST_BUTTON = "xpath://android.widget.ImageView[@content-desc='Add this article to a reading list']";
        ONBOARDING_GOT_IT_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/onboarding_button']";
        CREATE_NEW_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/create_button']";
        CREATE_NEW_LIST_NAME_FIELD = "xpath://*[@resource-id='org.wikipedia:id/text_input']";
        CREATE_NEW_LIST_OK_BUTTON = "xpath://*[@resource-id='android:id/button1']";
        BACK_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        NO_THANKS_BUTTON_SYNC_POPUP = "xpath://*[@resource-id='android:id/button2']";
        ARTICLE_TITLE = "xpath://*[@resource-id='heading_0']";
        NAME_OF_EXISTING_FOLDER_TML = "xpath://*[@text='{FOLDER_NAME}']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
