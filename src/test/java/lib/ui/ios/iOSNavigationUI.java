package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class iOSNavigationUI extends NavigationUI {
    static {
        MY_LISTS = "id:Saved";
        EXPLORE_BUTTON = "id:Explore";
    }

    public iOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }


}
