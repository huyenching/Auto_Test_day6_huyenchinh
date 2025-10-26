package actions.elements;

import common.BasePage;
import interfaces.elements.CheckboxPageInterface;
import org.openqa.selenium.WebDriver;

import static interfaces.elements.CheckboxPageInterface.*;

public class CheckboxPageAction extends BasePage {

    public CheckboxPageAction(WebDriver driver) {
        super(driver);

    }
    public void clickExpandAll() {
        waitForElementIsVisible(driver, EXPAND_ALL_BUTTON);
       // highlightElement(driver,EXPAND_ALL_BUTTON);
        clickToElementByJS(driver,EXPAND_ALL_BUTTON);
    }
    public void clickCheckbox(String buttonName) {
        waitForElementIsVisible(driver,BUTTON_CHECKBOX, buttonName);
        scrollIntoView(driver,BUTTON_CHECKBOX,buttonName);
        clickToElementByJS(driver, BUTTON_CHECKBOX, buttonName);
    }

    public String getResultText() {
        waitForElementIsVisible(driver, resultTextCheckbox);
        return getTextElement(driver, resultTextCheckbox);
    }
}
