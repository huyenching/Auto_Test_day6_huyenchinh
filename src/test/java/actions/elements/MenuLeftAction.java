package actions.elements;

import common.BasePage;
import interfaces.CommonInterface;
import org.openqa.selenium.WebDriver;

public class MenuLeftAction extends BasePage {

    WebDriver driver;
    public MenuLeftAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickOnMenu(String menu) {

       // highlightElement(driver, CommonInterface.Element_Menu, menu);
        //scrollIntoView(driver, CommonInterface.HOME_PAGE_MENU, menu);
        clickToElementByJS(driver, CommonInterface.Element_Menu, menu);
    }
}
