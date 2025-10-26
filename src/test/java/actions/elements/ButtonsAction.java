package actions.elements;

import common.BasePage;
import common.CommonUtils; // Cần import CommonUtils
import interfaces.elements.ButtonsInterface;
import org.openqa.selenium.WebDriver;

public class ButtonsAction extends BasePage {
    public ButtonsAction(WebDriver driver) {
        super(driver);
    }

    public void clickButton() {
        waitForElementIsVisible(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        scrollIntoView(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        doubleClickOnElement(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);

    }

    public String getMessage() {
         return getTextElement(driver, ButtonsInterface.DOUBLE_CLICK_MESSAGE);
    }
}