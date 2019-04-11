package lib.ui.ios;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI {
    static {
        MY_LISTS = "id:Saved";
        EXPLORE_BUTTON = "id:Explore";
    }

    public iOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }


}
