package actions;

import common.BasePage;
import common.CommonUtils;
import interfaces.CommonInterface;
import org.openqa.selenium.WebDriver;

public class HomePageAction extends BasePage {
    private WebDriver driver;
    public HomePageAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickOnMenu(String menu) {
        scrollIntoView(driver, CommonInterface.HOME_PAGE_MENU, menu);
//        highlightElement(driver, CommonInterface.HOME_PAGE_MENU, menu);
        CommonUtils.SleepInSeconds(3);
        clickToElement(driver, CommonInterface.HOME_PAGE_MENU, menu);
    }

}
